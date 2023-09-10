package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.service.EmployeeService;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

import java.util.List;

public class EmployeeControllerThymeleaf {

    private EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeControllerThymeleaf(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping(value = "employees/{employeeNumber}")
    public String deleteEmployee(@PathVariable int employeeNumber) {

        boolean result = employeeService.delete(employeeNumber);

        if(result) {
            return "redirect:/employees";
        }

        return "not-found";

    }

    @GetMapping(value = "/employees")
    public String showAllEmployees(Model model) {
        List<Employee> employeeList = employeeService.getAll();

        model.addAttribute("employeeList", employeeList);
        return "employee-list";
    }


    @GetMapping(value = "/employees/{employeeNumber}")
    public String showUpdateEmployeeDetailsForm(Model model, @PathVariable int employeeNumber) {
        Employee employee = employeeService.read(employeeNumber);

        if(employee==null){
            return "not-found";
        }

        model.addAttribute("employee", employee);

        return "edit-branch";
    }


    @PostMapping("/edit-employee")
    public String submitUpdateEmployeeDetailsForm(@ModelAttribute("employee") Employee employee){
        employeeService.update(employee);
        return "redirect:/";
    }


}
