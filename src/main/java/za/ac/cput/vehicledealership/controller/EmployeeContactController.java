package za.ac.cput.vehicledealership.controller;
/*  EmployeeContactController.java
    Controller for EmployeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.service.EmployeeContactService;
import java.util.Set;

@RestController
@RequestMapping("/employeeContact")
public class EmployeeContactController {


        @Autowired
        private EmployeeContactService employeeContactService;

        @PostMapping("/create")
        public EmployeeContact create(@RequestBody EmployeeContact employeeContact) {
            return employeeContactService.create(employeeContact);
        }

        @GetMapping("read/{id}")
        public EmployeeContact get(@PathVariable long id) {
            return employeeContactService.read(id);
        }

        @GetMapping("/all")
        public Set<EmployeeContact> getAll() {
            return employeeContactService.getAll();
        }

        @PostMapping("/update")
        public EmployeeContact update(@RequestBody EmployeeContact employeeContact) {
            return employeeContactService.update(employeeContact);
        }

        @DeleteMapping("/delete/{id}")
        public boolean delete(@PathVariable long id) {
            return employeeContactService.delete(id);
        }
    }

