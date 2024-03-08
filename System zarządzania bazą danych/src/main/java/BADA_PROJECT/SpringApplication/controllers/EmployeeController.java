package BADA_PROJECT.SpringApplication.controllers;

import BADA_PROJECT.SpringApplication.entities.Employees;
import BADA_PROJECT.SpringApplication.repository.EmployeesAttractionsRepository;
import BADA_PROJECT.SpringApplication.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@AllArgsConstructor
public class EmployeeController{
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/admin/pracownicy")
    public String getEmployees(Model model) {
        List<Employees> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        return "admin/pracownicy";
    }

    @PostMapping(path = "/admin/dodajPracownika")
    public String addEmployee(Model model, @ModelAttribute Employees employee) {
        employeeService.addEmployee(employee);
        return "redirect:/admin/pracownicy";
    }

    @GetMapping(path = "/admin/usunPracownika/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        employeeService.deleteEmployee(employeeId);
        return "redirect:/admin/pracownicy";
    }

    @PutMapping(path = "/pracownicy")
    public String modifyEmployee(@ModelAttribute Employees employee){
        employeeService.modifyEmployee(employee);
        return "pracownicy";
    }

    @GetMapping(path = "/admin/dodajPracownika")
    public String addEmployeeForm(Model model){
        Employees employees = new Employees();
        model.addAttribute("employee", employees);
        return "/admin/dodajPracownika";
    }

    @GetMapping(path = "/admin/edytujPracownika/{id}")
    public ModelAndView editEmployeeForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/admin/edytujPracownika");
        Employees employee = employeeService.getEmployee(id);
        mav.addObject("employee", employee);
        return mav;
    }
}