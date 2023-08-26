package za.ac.cput.vehicledealership.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.EmployeeService;
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
    public ResponseEntity<?> create(@Valid @RequestBody RegisterRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);

        if(errorMap != null) return errorMap;


        Employee createdEmployee = employeeService.register(request);
        if(createdEmployee == null) {
            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
        }
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
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
    public ResponseEntity<String> delete(@PathVariable String id) {
        boolean status = employeeService.delete(id);

        if(!status) {
            return ResponseEntity.badRequest().body("Employee " + id + " deleted successfully.");
        }
        return ResponseEntity.badRequest().body("Employee deleted successfully.");
    }
}