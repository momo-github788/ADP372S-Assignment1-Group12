package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.EmployeeService;
import za.ac.cput.vehicledealership.service.UserService;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;

@Controller
public class UpdateUserDetailsControllerThymeleaf {

    @Autowired
    private UserService userService;
    public UpdateUserDetailsControllerThymeleaf(EmployeeServiceImpl employeeService) {
        this.userService = UserService userService;
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") int id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_employee";
    }
}
