package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

@Controller
public class SignUpController {

    private UserServiceImpl userService;

    @Autowired
    public SignUpController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping(value="/signup")
    public String submitSignUpUserForm(@ModelAttribute User user) {
        userService.saveUser(user);
        return "signup-form";
    }

    //method to get signupForm details
    @GetMapping(value = "/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup-form";
    }

}
