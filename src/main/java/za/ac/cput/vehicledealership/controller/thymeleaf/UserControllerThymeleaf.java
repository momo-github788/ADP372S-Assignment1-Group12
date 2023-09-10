package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

public class UserControllerThymeleaf {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    public UserControllerThymeleaf(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/edit-user")
    public String submitUpdateUserDetailsForm(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/{userId}")
    public String showEditUserDetailsForm(@PathVariable int userId, Model model){
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "update_employee";
    }
}
