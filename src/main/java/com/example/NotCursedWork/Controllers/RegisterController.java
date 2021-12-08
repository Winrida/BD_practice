package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Register;
import com.example.NotCursedWork.repository.RegisterRepository;
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
public class RegisterController {
    @Autowired
    private RegisterRepository registerRepository;

    @GetMapping("/RegisterDB")
    public String RegisterController(Model model){
        Iterable<Register> registers = registerRepository.findAll();
        model.addAttribute("registers", registers);
        return "RegisterDB";
    }
    @PostMapping("/RegisterDB/{id}/remove")
    public String RegisterDelete(@PathVariable(value = "id") long id, Model model){
        Register registers = registerRepository.findById(id).orElseThrow();
        registerRepository.delete(registers);
        return "redirect:/RegisterDB";
    }
    @GetMapping("/RegisterDB/add")
    public String RegisterAddController(Model model){
        return "RegisterDB-add";
    }

    @PostMapping("/RegisterDB/add")
    public String RegisterAController(@RequestParam String Materials, @RequestParam boolean RepairStatus, @RequestParam String RepairTools, @RequestParam Long OrderId, Model model){
        Register register = new Register(Materials, RepairTools, RepairStatus, OrderId);
        registerRepository.save(register);
        return "redirect:/RegisterDB";
    }
    @GetMapping("/RegisterDB/{id}/edit")
    public String EditRegisterController(@PathVariable(value = "id") long id, Model model){
        if(!registerRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Register> register = registerRepository.findById(id);
        ArrayList<Register> res = new ArrayList<>();
        register.ifPresent(res::add);
        model.addAttribute("register", res);
        return "RegisterDB-edit";
    }

    @PostMapping("/RegisterDB/{id}/edit")
    public String RegisterUpdate(@PathVariable(value = "id") long id, @RequestParam String Materials, @RequestParam boolean RepairStatus, @RequestParam String RepairTools, @RequestParam Long OrderId, Model model){
        Register register = registerRepository.findById(id).orElseThrow();
        register.setMaterials(Materials);
        register.setRepairStatus(RepairStatus);
        register.setRepairTools(RepairTools);
        register.setOrderId(OrderId);

        registerRepository.save(register);
        return "redirect:/RegisterDB";
    }
}
