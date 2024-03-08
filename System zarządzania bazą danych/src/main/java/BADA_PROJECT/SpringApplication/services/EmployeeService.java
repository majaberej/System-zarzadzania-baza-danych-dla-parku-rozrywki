package BADA_PROJECT.SpringApplication.services;

import BADA_PROJECT.SpringApplication.entities.Employees;
import BADA_PROJECT.SpringApplication.repository.EmployeesRepository;
import BADA_PROJECT.SpringApplication.servicesInterfaces.EmployeeServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    EmployeesRepository employeesRepository;
    @Override
    public Employees getEmployee(int id){
        return employeesRepository.getReferenceById(id);
    }
    @Override
    public List<Employees> getEmployees() {
        return employeesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Employees addEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeesRepository.deleteById(id);
    }

    @Override
    public Employees modifyEmployee(Employees employee) {
        return employeesRepository.save(employee);
    }
}
