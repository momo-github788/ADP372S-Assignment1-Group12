package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeControllerThymeleaf {
    @GetMapping(value = "/")
    public String home(Model model) {
        return "landing";
    }


}
