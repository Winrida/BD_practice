package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Order1;
import com.example.NotCursedWork.models.Worker;
import com.example.NotCursedWork.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/WorkerDB")
    public String WorkerController(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        return "WorkerDB";
    }
    @PostMapping("/WorkerDB/{id}/remove")
    public String WorkerDelete(@PathVariable(value = "id") long id, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        workerRepository.delete(worker);
        return "redirect:/WorkerDB";
    }
    @GetMapping("/WorkerDB/add")
    public String WorkerAddController(Model model){
        return "WorkerDB-add";
    }

    @PostMapping("/WorkerDB/add")
    public String WorkerAController(@RequestParam String WName, @RequestParam String WSurname, @RequestParam String WTelephone, Model model){
        Worker worker = new Worker(WName, WSurname, WTelephone);
        workerRepository.save(worker);
        return "redirect:/WorkerDB";
    }
    @GetMapping("/WorkerDB/{id}/edit")
    public String EditWorkerController(@PathVariable(value = "id") long id, Model model){
        if(!workerRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Worker> worker = workerRepository.findById(id);
        ArrayList<Worker> res = new ArrayList<>();
        worker.ifPresent(res::add);
        model.addAttribute("worker", res);
        return "WorkerDB-edit";
    }

    @PostMapping("/WorkerDB/{id}/edit")
    public String WorkerUpdate(@PathVariable(value = "id") long id, @RequestParam String WName, @RequestParam String WSurname, @RequestParam String WTelephone, Model model){
        Worker worker = workerRepository.findById(id).orElseThrow();
        worker.setWName(WName);
        worker.setWSurname(WSurname);
        worker.setWTelephone(WTelephone);
        workerRepository.save(worker);
        return "redirect:/WorkerDB";
    }
}
