package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.service.EmployeeService;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

import java.util.List;

@Controller
public class UpdateEmployeeDetailsControllerThymeleaf {

    @Autowired
    private EmployeeService employeeService;


    public UpdateEmployeeDetailsControllerThymeleaf(EmployeeServiceImpl employeeService) {
        this.employeeService = EmployeeService employeeService;
    }

    @GetMapping(value = "/updateEmployeeDetails")
    public String showUpdateEmployeeDetailsForm(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        model.addAttribute("employees", new Employee());
        return "updateEmployeeDetails";
    }


    @PostMapping(value = "employees/{employeeNumber}")
    public String deleteEmployee(@PathVariable int employeeNumber) {

        boolean result = employeeService.delete(String.valueOf(employeeNumber));

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


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
