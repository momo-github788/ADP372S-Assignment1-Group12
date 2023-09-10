package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.ac.cput.vehicledealership.domain.User;

@Controller
public class LoginController {

    //method to get login form
    @RequestMapping(value ="/login", method= RequestMethod.GET)
    public String getUser() {
        //return html page
        return "login-form";
    }

    //checking for login credentials
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@ModelAttribute(name="user")User user, Model model) {
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();
        //Testing purposes
        System.out.println("inside logging function");
        System.out.println("emailAddress: " + emailAddress);
        System.out.println("password: " + password);


        if("admin@gmail.com".equals(emailAddress) && "admin".equals(password)) {
            //if emailAddress and password is correct, we are returning home page
            return "post-listings";
        }
        // if emailAddress or password is wrong
        model.addAttribute("invalidCredentials", true);
        //returning again login page
        return "login-form";
    }
}
