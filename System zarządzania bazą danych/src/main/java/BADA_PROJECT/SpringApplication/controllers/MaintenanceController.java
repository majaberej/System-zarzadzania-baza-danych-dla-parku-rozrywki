package BADA_PROJECT.SpringApplication.controllers;

import BADA_PROJECT.SpringApplication.DTO.AttractionEmployeeDTO;
import BADA_PROJECT.SpringApplication.DTO.AttractionMaintenanceDTO;
import BADA_PROJECT.SpringApplication.entities.Attractions;
import BADA_PROJECT.SpringApplication.entities.Employees;
import BADA_PROJECT.SpringApplication.entities.Maintenances;
import BADA_PROJECT.SpringApplication.services.EmployeeService;
import BADA_PROJECT.SpringApplication.services.MaintenanceService;
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
public class MaintenanceController{
    @Autowired
    MaintenanceService maintenanceService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping(path = "/admin/konserwacje")
    public String getMaintenancesAdmin(Model model) {
        List<AttractionMaintenanceDTO> dto = dtoConverterGet();
        model.addAttribute("maintenances", dto);
        return "admin/konserwacje";
    }

    @GetMapping(path = "/user/konserwacje")
    public String getMaintenancesUser(Model model) {
        List<AttractionMaintenanceDTO> dto = dtoConverterGet();
        model.addAttribute("maintenances", dto);
        return "user/konserwacje";
    }

    @PostMapping(path = "/admin/dodajKonserwacje")
    public String addMaintenanceAdmin(@ModelAttribute AttractionMaintenanceDTO dto){

        Maintenances maintenance = dtoConverterAdd(dto);
        maintenanceService.addMaintenance(maintenance);

        return "redirect:/admin/konserwacje";
    }

    @PostMapping(path = "/user/dodajKonserwacje")
    public String addMaintenanceUser(@ModelAttribute AttractionMaintenanceDTO dto){

        Maintenances maintenance = dtoConverterAdd(dto);
        maintenanceService.addMaintenance(maintenance);

        return "redirect:/user/konserwacje";
    }

    @PostMapping(path = "/admin/edytujKonserwacje")
    public String editMaintenanceAdmin(@ModelAttribute Maintenances maintenances){
        maintenanceService.modifyMaintenance(maintenances);
        return "redirect:/admin/konserwacje";
    }
    @PostMapping(path = "/user/edytujKonserwacje")
    public String editMaintenanceUser(@ModelAttribute AttractionMaintenanceDTO dto){

        Maintenances maintenance = dtoConverterAdd(dto);
        maintenanceService.addMaintenance(maintenance);

        return "redirect:/user/konserwacje";
    }

    @GetMapping(path = "/admin/usunKonserwacje/{maintenanceId}")
    public String deleteMaintenanceAdmin(@PathVariable int maintenanceId) {
        maintenanceService.deleteMaintenance(maintenanceId);
        return "redirect:/admin/konserwacje";
    }

    @GetMapping(path = "/user/usunKonserwacje/{maintenanceId}")
    public String deleteMaintenanceUser(@PathVariable int maintenanceId) {
        maintenanceService.deleteMaintenance(maintenanceId);
        return "redirect:/user/konserwacje";
    }

    @PutMapping(path = "/admin/konserwacje")
    public String modifyMaintenanceAdmin(@ModelAttribute Maintenances maintenances){
        maintenanceService.modifyMaintenance(maintenances);
        return "admin/konserwacje";
    }

    @PutMapping(path = "/user/konserwacje")
    public String modifyMaintenance(@ModelAttribute Maintenances maintenances){
        maintenanceService.modifyMaintenance(maintenances);
        return "user/konserwacje";
    }

    @GetMapping(path = "/admin/dodajKonserwacje")
    public String addMaintenanceFormAdmin(Model model){
        AttractionMaintenanceDTO dto = new AttractionMaintenanceDTO();
        model.addAttribute("maintenanceAttraction",dto);
        return "admin/dodajKonserwacje";
    }

    @GetMapping(path = "/user/dodajKonserwacje")
    public String addMaintenanceFormUser(Model model){
        AttractionMaintenanceDTO dto = new AttractionMaintenanceDTO();
        model.addAttribute("maintenanceAttraction",dto);
        return "user/dodajKonserwacje";
    }

    @GetMapping(path = "/admin/edytujKonserwacje/{id}")
    public ModelAndView editMaintenanceFormAdmin(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/admin/edytujKonserwacje");
        AttractionMaintenanceDTO dto = dtoConverterEdit(id);
        mav.addObject("maintenanceAttraction", dto);
        return mav;
    }

    @GetMapping(path = "/user/edytujKonserwacje/{id}")
    public ModelAndView editMaintenanceFormUser(@PathVariable int id){
        ModelAndView mav = new ModelAndView("/user/edytujKonserwacje");
        AttractionMaintenanceDTO dto = dtoConverterEdit(id);
        mav.addObject("maintenanceAttraction", dto);
        return mav;
    }


    public List<AttractionMaintenanceDTO> dtoConverterGet(){

        List<Maintenances> maintenances = maintenanceService.getMaintenances();
        List<AttractionMaintenanceDTO> dto = new ArrayList<>();
        for (int i = 0; i < maintenances.size(); i++){
            StringBuilder ids = new StringBuilder();
            AttractionMaintenanceDTO temp = new AttractionMaintenanceDTO();
            temp.setId(maintenances.get(i).getId());
            temp.setDate(maintenances.get(i).getDate());
            temp.setAttraction(maintenances.get(i).getAttraction());
            List<Employees> employee = maintenances.get(i).getEmployees();
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

    public Maintenances dtoConverterAdd(AttractionMaintenanceDTO dto){
        List<Employees> employees = new ArrayList<>();
        Maintenances maintenance = new Maintenances();
        maintenance.setId(dto.getId());
        maintenance.setDate(dto.getDate());
        maintenance.setAttraction(dto.getAttraction());
        String[] ids = dto.getEmployees().replaceAll("[^0-9,]", "").split(",");
        for (int i = 0; i < ids.length; i++){
            employees.add(i, employeeService.getEmployee(Integer.parseInt(ids[i])));
        }
        maintenance.setEmployees(employees);
        return maintenance;
    }

    public AttractionMaintenanceDTO dtoConverterEdit(int id){

        Maintenances maintenance = maintenanceService.getMaintenance(id);
        StringBuilder ids = new StringBuilder();
        AttractionMaintenanceDTO dto = new AttractionMaintenanceDTO();
        dto.setId(maintenance.getId());
        dto.setDate(maintenance.getDate());
        dto.setAttraction(maintenance.getAttraction());
        List<Employees> employee = maintenance.getEmployees();
        for (int j = 0; j < employee.size(); j++){
            ids.append(employee.get(j).getId()).append(",");
        }
        //ids.deleteCharAt(ids.length()-1);
        dto.setEmployees(ids.toString());
        return dto;
    }
}
