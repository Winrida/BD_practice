package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Drug;
import com.example.NotCursedWork.repository.DrugRepository;
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
public class DrugController {
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/DrugDB")
    public String DrugController(Model model){
        Iterable<Drug> drugs = drugRepository.findAll();
        model.addAttribute("drugs", drugs);
        return "DrugDB";
    }
    @PostMapping("/DrugDB/{id}/remove")
    public String DrugDelete(@PathVariable(value = "id") long id, Model model){
        Drug drug = drugRepository.findById(id).orElseThrow();
        drugRepository.delete(drug);
        return "redirect:/DrugDB";
    }
    @GetMapping("/DrugDB/add")
    public String DrugAddController(Model model){
        return "DrugDB-add";
    }

    @PostMapping("/DrugDB/add")
    public String DrugAController(@RequestParam Integer Pills, @RequestParam Integer Antibiotics, @RequestParam Integer Vitamins, Model model){
        Drug drug = new Drug(Pills, Antibiotics, Vitamins);
        drugRepository.save(drug);
        return "redirect:/DrugDB";
    }
    @GetMapping("/DrugDB/{id}/edit")
    public String EditDrugController(@PathVariable(value = "id") long id, Model model){
        if(!drugRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Drug> drug = drugRepository.findById(id);
        ArrayList<Drug> res = new ArrayList<>();
        drug.ifPresent(res::add);
        model.addAttribute("drug", res);
        return "DrugDB-edit";
    }

    @PostMapping("/DrugDB/{id}/edit")
    public String DrugUpdate(@PathVariable(value = "id") long id, @RequestParam Integer Pills, @RequestParam Integer Antibiotics, @RequestParam Integer Vitamins, Model model){
        Drug drug = drugRepository.findById(id).orElseThrow();
        drug.setPills(Pills);
        drug.setAntibiotics(Antibiotics);
        drug.setVitamins(Vitamins);
        drugRepository.save(drug);
        return "redirect:/DrugDB";
    }
}