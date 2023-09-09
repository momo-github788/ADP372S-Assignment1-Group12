package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.service.VehicleService;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;
import za.ac.cput.vehicledealership.service.impl.VehicleServiceImpl;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {


    private PostServiceImpl postService;
    private VehicleServiceImpl vehicleService;

    @Autowired
    public HomeController(PostServiceImpl postService, VehicleServiceImpl vehicleService) {
        this.postService = postService;
        this.vehicleService = vehicleService;
    }

//    @PostMapping(value = "/results")
//    public String getHome(Model model, @RequestParam(required = false) VehicleCondition condition) {
//
//        if(condition!=null) {
//            model.addAttribute("condition", condition);
//            model.addAttribute("postList", postService.getAll(condition,null,null));
//        } else {
//            model.addAttribute("postList", postService.getAll(null,null,null));
//        }
//
//
//        return "post-listings";
//    }

    @GetMapping(value = "/results")
    public String getHome(Model model) {

        model.addAttribute("postList", postService.getAll());

        return "post-listings";
    }
}
