package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.User;

@Controller
public class LoginController {

    //method to get login form
    @GetMapping(value ="/login")
    public String showLoginForm(@ModelAttribute User user) {
        //return html page
        return "login-form";
    }


    //checking for login credentials
    @PostMapping(value="/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();

        if(emailAddress.equals("admin@gmail.com") && password.equals("password")) {
            System.out.println("Details correct");
            //if emailAddress and password is correct, we are returning home page

            return "/landing";
        }

        // if emailAddress or password is wrong

        model.addAttribute("invalidCredentials", true);
        //returning again login page
        return "login-form";
    }
}
