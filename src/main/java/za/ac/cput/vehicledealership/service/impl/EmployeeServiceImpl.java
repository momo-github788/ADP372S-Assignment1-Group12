package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.repository.impl.EmployeeRepositoryImpl;
import za.ac.cput.vehicledealership.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl employeeService = null;
    private EmployeeRepositoryImpl employeeRepository = null;

    public EmployeeServiceImpl() {
        this.employeeRepository = EmployeeRepositoryImpl.getEmployeeRepository();
    }

    public static EmployeeServiceImpl getEmployeeService() {
        if(employeeService == null) {
            employeeService = new EmployeeServiceImpl();
        }
        return employeeService;
    }


    @Override
    public Employee create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Employee read(Long employeeNumber) {
        return employeeRepository.read(employeeNumber);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean delete(Long employeeNumber) {
        return employeeRepository.delete(employeeNumber);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
