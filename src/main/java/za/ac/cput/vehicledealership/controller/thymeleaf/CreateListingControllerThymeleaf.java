package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

@Controller
public class CreateListingControllerThymeleaf {

    private final PostServiceImpl postService;

    public CreateListingControllerThymeleaf(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/create-listing")
    public String showCreateListingForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("vehicle", new Vehicle());
        return "create-listing";
    }

    @PostMapping(value = "/create-listing")
    public String submitCreateListingForm(@ModelAttribute Post post, @ModelAttribute Vehicle vehicle) {

        post.setVehicle(vehicle);
        System.out.println("created branch");
        System.out.println(post);

        //postService.create();

        return "redirect:/";
    }
}