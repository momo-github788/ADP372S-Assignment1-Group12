package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.EmployeeService;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

import java.util.List;

@Controller
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

    @GetMapping(value="/edit-employee")
    public String showEditEmployeeDetailsForm(@ModelAttribute Employee employee) {

        return "edit-employee-details";
    }


    @PostMapping("/edit-employee")
    public String submitUpdateEmployeeDetailsForm(@ModelAttribute("employee") Employee employee){
        employeeService.update(employee);
        return "redirect:/";
    }


}
