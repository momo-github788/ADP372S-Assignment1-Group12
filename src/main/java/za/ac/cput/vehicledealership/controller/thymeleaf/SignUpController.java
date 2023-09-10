package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.User;

@Controller
public class SignUpController {
    //method to get signup form
    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String getUser(@ModelAttribute User user) {
        //Testing purposes
        System.out.println("GET Testing");
        return "signup-form";
    }
    //method to get signupForm details
    @RequestMapping(value = "/signup", method= RequestMethod.POST)
    public String user(@ModelAttribute User user) {
        return "login-form";
    }
}
