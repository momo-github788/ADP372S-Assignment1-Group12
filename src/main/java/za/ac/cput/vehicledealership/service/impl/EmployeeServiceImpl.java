package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: George Tapiwa Charimba(220073465)
    Date: 10 June 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.ContactDetailRepository;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static za.ac.cput.vehicledealership.domain.ERole.ADMIN;

@Service
public class EmployeeServiceImpl {


    private EmployeeRepository employeeRepository;
    private ContactDetailServiceImpl contactDetailService;
    private ContactDetailRepository contactDetailRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, ContactDetailServiceImpl contactDetailService, ContactDetailRepository contactDetailRepository) {
        this.employeeRepository = employeeRepository;
        this.contactDetailService = contactDetailService;
        this.passwordEncoder = passwordEncoder;
        this.contactDetailRepository = contactDetailRepository;
    }

    public Set<ContactDetail> getContactsByEmployeeId(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);


        if (employee != null) {
            System.out.println("getContactsByEmployeeId");
            System.out.println(employee.getContactDetails());
            return employee.getContactDetails();
        } else {
            // Handle the case where the employee with the given ID doesn't exist
            return Collections.emptySet();
        }
    }

    public Employee readByEmailAddress(String emailAddress) {
        Employee employee = employeeRepository.findByEmailAddress(emailAddress);

        if(employee!=null){
            return this.employeeRepository.findByEmailAddress(emailAddress);
        }
        System.out.println("Employee " + emailAddress + " not exist");
        return null;

    }

    public Employee readByEmail(String emailAddress) {
        Employee emp = employeeRepository.findByEmailAddress(emailAddress);

        if(emp!=null){
            return emp;
        }
        return null;
    }


    public Employee read(int employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElse(null);
    }



    public Employee update(Employee employee) {

        if(employeeRepository.existsById(employee.getEmployeeNumber())) {
            System.out.println("employee exists with id " + employee.getEmployeeNumber());
            employee.setRoles(Set.of(new Role(ADMIN)));
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            return this.employeeRepository.save(employee);
        }
        System.out.println("employee doesnt exist with id " + employee.getEmployeeNumber());

        return null;
    }


    public void deleteAll() {
        contactDetailRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    public boolean delete(Integer employeeNumber) {

        Employee employee = employeeRepository.findById(employeeNumber).orElse(null);

        if(employee !=null) {
            this.employeeRepository.deleteById(employeeNumber);
            this.contactDetailRepository.deleteAllByEmployee(employee);
            return true;
        }
        return false;
    }


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        this.employeeRepository.save(employee);
    }


    public Employee getEmployeeById(int id){
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()){
            employee = optional.get();
        }else {
            throw new RuntimeException("Employee not found for id ::" + id);
        }
        return employee;
    }
}
