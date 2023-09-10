package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

@Controller
public class UserControllerThymeleaf {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    public UserControllerThymeleaf(UserServiceImpl userService) {
        this.userService = userService;
    }



    @PostMapping("/edit-user")
    public String submitEditUserDetailsForm(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }


    @GetMapping(value="/edit-user")
    public String showEditUserDetailsForm(@ModelAttribute User user) {
        userService.update(user);
        return "edit-user-details";
    }

}
