package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Order1;
import com.example.NotCursedWork.repository.OrderRepository;
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
public class ZapisController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/zapis")
    public String ZapisController(Model model){
        Iterable<Order1> order1s = orderRepository.findAll();
        model.addAttribute("order1s", order1s);
        return "zapis";
    }

    @GetMapping("/zapis/{id}")
    public String MoreZapisController(@PathVariable(value = "id") long id, Model model){
        if(!orderRepository.existsById(id)){
                   return "redirect:/index";
        }
        Optional<Order1> order1 = orderRepository.findById(id);
        ArrayList<Order1> res = new ArrayList<>();
        order1.ifPresent(res::add);
        model.addAttribute("order1", res);
        return "zapis-details";
    }

    @GetMapping("/zapis/{id}/edit")
    public String EditZapisController(@PathVariable(value = "id") long id, Model model){
        if(!orderRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Order1> order1 = orderRepository.findById(id);
        ArrayList<Order1> res = new ArrayList<>();
        order1.ifPresent(res::add);
        model.addAttribute("order1", res);
        return "zapis-edit";
    }

    @PostMapping("/zapis/{id}/edit")
    public String ZapisUpdate(@PathVariable(value = "id") long id, @RequestParam double Price, @RequestParam String Diagnostics, Model model){
        Order1 order1 = orderRepository.findById(id).orElseThrow();
        order1.setPrice(Price);
        order1.setDiagnostics(Diagnostics);
        orderRepository.save(order1);
        return "redirect:/zapis";
    }
    @PostMapping("/zapis/{id}/remove")
    public String ZapisDelete(@PathVariable(value = "id") long id, Model model){
        Order1 order1 = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(order1);
        return "redirect:/zapis";
    }

    @GetMapping("/zapis/add")
    public String ZapisAddController(Model model){
        return "zapis-add";
    }

    @PostMapping("/zapis/add")
    public String ZapishuController(@RequestParam String Diagnostics, Model model){
        Order1 order1 = new Order1(Diagnostics);
        orderRepository.save(order1);
        return "redirect:/zapis";
    }
}
