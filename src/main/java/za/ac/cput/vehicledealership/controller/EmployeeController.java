package za.ac.cput.vehicledealership.controller;
/*  Employeecontroller.java
    Controller for Employee class
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;

import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeServiceImpl employeeService;
    private ErrorValidationServiceImpl errorValidationService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService, ErrorValidationServiceImpl errorValidationService) {
        this.employeeService = employeeService;
        this.errorValidationService = errorValidationService;
    }

    @GetMapping("readEmail/{emailAddress}")
    public ResponseEntity<?> get(@PathVariable String emailAddress){
        Employee employee = employeeService.readByEmailAddress(emailAddress);
        if (employee == null){
            return ResponseEntity.badRequest().body("Employee with email " + emailAddress + " not found");
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Employee employee = employeeService.read(id);

        if(employee == null) {
            return ResponseEntity.badRequest().body("Employee with id " + id + " not found.");
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.update(employee);
        if(updatedEmployee == null) {
            return ResponseEntity.badRequest().body("Error updating record.. Please try again later");
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = employeeService.delete(id);

        if(status) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Employee deleted successfully.");
    }
}