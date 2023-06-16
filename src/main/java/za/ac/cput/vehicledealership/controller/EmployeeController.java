package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.service.EmployeeService;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping("read/{id}")
    public Employee get(@PathVariable long id) {
        return employeeService.read(id);
    }

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return employeeService.delete(id);
    }
}