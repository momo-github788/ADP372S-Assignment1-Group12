package za.ac.cput.vehicledealership.service;

/*  EmployeeService.java
    Service Interface for Employee Domain
    Author: George Tapiwa Charimba (220073465)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;


public interface EmployeeService extends IService<Employee, String> {
    List<Employee> getAll();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int Id);
}
