package com.example.NotCursedWork.Controllers;

import com.example.NotCursedWork.models.Order1;
import com.example.NotCursedWork.models.Employee;
import com.example.NotCursedWork.repository.EmpRepository;
import com.example.NotCursedWork.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmpRepository empRepository;

    @GetMapping("/EmployeeDB")
    public String EmployeeController(Model model){
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "EmployeeDB";
    }
    @GetMapping("/EmployeeDB/filter")
    public String Worker(Model model){
        return "EmployeeDB-filter";
    }
    @PostMapping("/EmployeeDB/{id}/remove")
    public String EmployeeDelete(@PathVariable(value = "id") long id, Model model){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employeeRepository.delete(employee);
        return "redirect:/EmployeeDB";
    }
    @PostMapping("EmployeeDB/filter")
    public String EmployeeFilter(@RequestParam Long id, Model model){
        List<Employee> employees = empRepository.findAllbyidId(id);
        model.addAttribute("emp", employees);
        return "EmployeeDB-filter";
    }
    @GetMapping("/EmployeeDB/add")
    public String EmployeeAddController(Model model){
        return "EmployeeDB-add";
    }

    @PostMapping("/EmployeeDB/add")
    public String EmployeeAController(@RequestParam String WName, @RequestParam String Workplace, @RequestParam String WTelephone, Model model){
        Employee employee = new Employee(WName, Workplace, WTelephone);
        employeeRepository.save(employee);
        return "redirect:/EmployeeDB";
    }
    @GetMapping("/EmployeeDB/{id}/edit")
    public String EditEmployeeController(@PathVariable(value = "id") long id, Model model){
        if(!employeeRepository.existsById(id)){
            return "redirect:/index";
        }
        Optional<Employee> employee = employeeRepository.findById(id);
        ArrayList<Employee> res = new ArrayList<>();
        employee.ifPresent(res::add);
        model.addAttribute("employee", res);
        return "EmployeeDB-edit";
    }

    @PostMapping("/EmployeeDB/{id}/edit")
    public String EmployeeUpdate(@PathVariable(value = "id") long id, @RequestParam String WName, @RequestParam String Workplace, @RequestParam String WTelephone, Model model){
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setWName(WName);
        employee.setWorkplace(Workplace);
        employee.setWTelephone(WTelephone);
        employeeRepository.save(employee);
        return "redirect:/EmployeeDB";
    }
}
