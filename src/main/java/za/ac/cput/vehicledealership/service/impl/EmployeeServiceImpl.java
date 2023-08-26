package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.EmployeeRegisterDTO;
import za.ac.cput.vehicledealership.factory.EmployeeContactFactory;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl  {


    private ModelMapper modelMapper;
    private EmployeeRepository employeeRepository;
    private ContactServiceImpl contactService;
    private EmployeeContactServiceImpl employeeContactService;


    @Autowired
    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository, ContactServiceImpl contactService, EmployeeContactServiceImpl employeeContactService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.contactService = contactService;
        this.employeeContactService = employeeContactService;
    }


    public Employee register(RegisterRequest request) {

        Contact emailContact = contactService.create(ContactType.EMAIL, request.getEmailAddress());
        Employee createdEmployee = EmployeeFactory.createEmployee(request.getName(), request.getPassword());
        EmployeeContact employeeContactEmail = EmployeeContactFactory.createEmployeeContact(createdEmployee.getEmployeeNumber(), emailContact.getContactId());

        employeeContactService.create(employeeContactEmail);
        contactService.create(emailContact.getContactType(), emailContact.getValue());

        return employeeRepository.save(createdEmployee);

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


    public Employee read(String employeeNumber) {
        return employeeRepository.findById(employeeNumber)
                .orElse(null);
    }


    public Employee update(Employee employee) {
        if(employeeRepository.existsById(employee.getEmployeeNumber())) {
            return this.employeeRepository.save(employee);
        }
        return null;
    }


    public boolean delete(String employeeNumber) {
        if(employeeRepository.existsById(employeeNumber)) {
            this.employeeRepository.deleteById(employeeNumber);
        }
        return false;
    }


    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
