package BADA_PROJECT.SpringApplication.controllers;

import BADA_PROJECT.SpringApplication.DTO.AttractionEmployeeDTO;
import BADA_PROJECT.SpringApplication.entities.Attractions;
import BADA_PROJECT.SpringApplication.entities.Employees;
import BADA_PROJECT.SpringApplication.services.AttractionService;
import BADA_PROJECT.SpringApplication.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class AttractionsController{
    @Autowired
    AttractionService attractionService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/admin/atrakcje")
    public String getAttractionsAdmin(Model model) {
        List<AttractionEmployeeDTO> dto = dtoConverterGet();
        model.addAttribute("attractions", dto);
        return "admin/atrakcje";
    }

    @GetMapping(path = "/user/atrakcje")
    public String getAttractionsUser(Model model) {
        List<AttractionEmployeeDTO> dto = dtoConverterGet();
        model.addAttribute("attractions", dto);
        return "user/atrakcje";
    }

    @PostMapping(path = "/admin/dodajAtrakcje")
    public String addAttraction(@ModelAttribute AttractionEmployeeDTO dto){
        List<Employees> employees = new ArrayList<>();
        Attractions attraction = new Attractions();
        attraction.setId(dto.getId());
        attraction.setName(dto.getName());
        attraction.setType(dto.getType());
        String[] ids = dto.getEmployees().replaceAll("[^0-9,]", "").split(",");
        for (int i = 0; i < ids.length; i++){
            employees.add(i, employeeService.getEmployee(Integer.parseInt(ids[i])));
        }
        attraction.setEmployees(employees);
        attractionService.addAttraction(attraction);
        return "redirect:/admin/atrakcje";
    }

    @PostMapping(path = "/admin/edytujAtrakcje")
    public String modifyAttraction(@ModelAttribute Attractions attraction){
        attractionService.modifyAttraction(attraction);

        return "redirect:/admin/atrakcje";
    }


    @GetMapping(path = "/admin/usunAtrakcje/{attractionId}")
    public String deleteAttraction(@PathVariable int attractionId) {
        attractionService.deleteAttraction(attractionId);
        return "redirect:/admin/atrakcje";
    }

    @GetMapping(path = "/admin/dodajAtrakcje")
    public String addAttractionForm(Model model){
        AttractionEmployeeDTO dto = new AttractionEmployeeDTO();
        model.addAttribute("attraction", dto);
        return "/admin/dodajAtrakcje";
    }

    @GetMapping(path = "/admin/edytujAtrakcje/{id}")
    public ModelAndView editAttractionForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/admin/edytujAtrakcje");
        Attractions attraction = attractionService.getAttraction(id);
        StringBuilder ids = new StringBuilder();
        AttractionEmployeeDTO dto = new AttractionEmployeeDTO();
        dto.setId(attraction.getId());
        dto.setName(attraction.getName());
        dto.setType(attraction.getType());
        List<Employees> employee = attraction.getEmployees();
        for (int j = 0; j < employee.size(); j++){
            ids.append(employee.get(j).getId()).append(",");
        }
        if (ids.length() > 0) {
            ids.deleteCharAt(ids.length() - 1);
        }
        dto.setEmployees(ids.toString());
        mav.addObject("attraction", dto);
        return mav;
    }

    public List<AttractionEmployeeDTO> dtoConverterGet(){

        List<Attractions> attractions = attractionService.getAttractions();
        List<AttractionEmployeeDTO> dto = new ArrayList<>();
        for (int i = 0; i < attractions.size(); i++){
            StringBuilder ids = new StringBuilder();
            AttractionEmployeeDTO temp = new AttractionEmployeeDTO();
            temp.setId(attractions.get(i).getId());
            temp.setName(attractions.get(i).getName());
            temp.setType(attractions.get(i).getType());
            List<Employees> employee = attractions.get(i).getEmployees();
            for (int j = 0; j < employee.size(); j++){
                ids.append(employee.get(j).getName()).append(" ").append(employee.get(j).getSurname()).append(" [ID ").append(employee.get(j).getId()).append("], ");
            }
            if (ids.length() > 0) {
                ids.delete(ids.length() - 2, ids.length());
            }
            temp.setEmployees(ids.toString());
            dto.add(temp);
        }
        return dto;
    }

}
