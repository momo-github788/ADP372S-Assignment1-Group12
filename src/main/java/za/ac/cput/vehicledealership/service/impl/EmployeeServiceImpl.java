package za.ac.cput.vehicledealership.service.impl;

/*  EmployeeServiceImpl.java
    Implementation of EmployeeService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.service.EmployeeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl  {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee register(Employee employee) {

        //employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        //employee.setConfirmPassword("");

//        if (employeeRepository.existsByEmailAddress(employee.getEmailAddress())) {
//            throw new RuntimeException("Account already exists with this email address");
//        }
        return employeeRepository.save(employee);
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
