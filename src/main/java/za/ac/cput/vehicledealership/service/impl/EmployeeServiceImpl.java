package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee read(Long employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if(employeeRepository.existsById(employee.getEmployeeNumber())) {
            return this.employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public boolean delete(Long employeeNumber) {
        if(employeeRepository.existsById(employeeNumber)) {
            this.employeeRepository.deleteById(employeeNumber);
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
