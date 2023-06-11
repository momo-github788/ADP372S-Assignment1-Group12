package za.ac.cput.vehicledealership.service;

/*  EmployeeService.java
    Service Interface for Employee Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Employee;

import java.util.List;

public interface EmployeeService extends IService<Employee, Long> {
    List<Employee> getAll();
}
