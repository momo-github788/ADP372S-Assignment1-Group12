package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.EmployeeRegisterDTO;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.repository.ContactDetailRepository;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl {


    private EmployeeRepository employeeRepository;
    private ContactDetailServiceImpl contactDetailService;
    private ContactDetailRepository contactDetailRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ContactDetailServiceImpl contactDetailService, ContactDetailRepository contactDetailRepository) {
        this.employeeRepository = employeeRepository;
        this.contactDetailService = contactDetailService;
        this.contactDetailRepository = contactDetailRepository;
    }


    public Employee register(EmployeeRegisterDTO request) {
        Employee createdEmployee = EmployeeFactory.createEmployee(request.getName(), request.getEmailAddress(), request.getPassword());

        if(!employeeRepository.existsByEmailAddress(createdEmployee.getEmailAddress())) {
            return employeeRepository.save(createdEmployee);
        }

        System.out.println("Employee email already exixts");
        return null;

    }

    public boolean login(Employee employee) {

//        UserLoginDTO userLoginDTO = null;
//        try {
//            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));
//            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
//            String token = tokenProvider.createToken(authentication);
//
//            userLoginDTO = new UserLoginDTO(userDetails.getFullName(), userDetails.getUsername(), token, userDetails.getAuthorities());
//        } catch (DisabledException e) {
//            throw new AuthenticationException("User account is disabled");
//        } catch (BadCredentialsException e) {
//            throw new AuthenticationException("Invalid credentials");
//        }
//        return userLoginDTO;
        return true;
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

    public Employee readByEmail(String emailAddress) {
        Employee emp = employeeRepository.findEmployeeByEmailAddress(emailAddress);

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
            return this.employeeRepository.save(employee);
        }
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
