package za.ac.cput.vehicledealership.controller;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.dto.EmployeeRegisterDTO;

import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeServiceImpl employeeService;
    private ErrorValidationServiceImpl errorValidationService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService, ErrorValidationServiceImpl errorValidationService) {
        this.employeeService = employeeService;
        this.errorValidationService = errorValidationService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeRegisterDTO request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);

        if(errorMap != null) return errorMap;


        Employee createdEmployee = employeeService.register(request);
        if(createdEmployee == null) {
            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
        }
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
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