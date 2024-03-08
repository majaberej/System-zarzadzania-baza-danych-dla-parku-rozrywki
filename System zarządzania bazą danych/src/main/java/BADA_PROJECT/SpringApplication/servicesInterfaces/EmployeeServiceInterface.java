package BADA_PROJECT.SpringApplication.servicesInterfaces;

import BADA_PROJECT.SpringApplication.entities.Employees;

public interface EmployeeServiceInterface {
    Employees getEmployee(int id);
    Iterable<Employees> getEmployees();
    Employees addEmployee(Employees employee);
    void deleteEmployee(int id);
    Employees modifyEmployee(Employees employee);
}
