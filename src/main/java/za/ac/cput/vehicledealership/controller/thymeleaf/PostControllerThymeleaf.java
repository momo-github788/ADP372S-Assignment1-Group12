package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class PostControllerThymeleaf {

    private PostServiceImpl postService;
    private BranchServiceImpl branchService;

    @Autowired
    public PostControllerThymeleaf(PostServiceImpl postService, BranchServiceImpl branchService) {
        this.postService = postService;
        this.branchService = branchService;
    }

    @GetMapping(value = "/search")
    public String searchAllPosts(Model model, @RequestParam(required = false) String title) {
        System.out.println("Searching by " + title);

        List<Post> posts = postService.getAll(title);
        if(posts.isEmpty()) {
            return "not-found";
        }

        model.addAttribute("title", title);
        model.addAttribute("postList", posts);
        return "post-listings";
    }


    @GetMapping(value = "/create-listing")
    public String showCreateListingForm(Model model) {

        List<String> fuelTypes = EnumSet.allOf(FuelType.class).stream().map(e -> StringUtils.capitalize(e.name())).collect(Collectors.toList());
        List<String> vehicleConditions = EnumSet.allOf(VehicleCondition.class).stream().map(e -> StringUtils.capitalize(e.name())).collect(Collectors.toList());
        List<String> bodyTypes = EnumSet.allOf(BodyType.class).stream().map(e -> StringUtils.capitalize(e.name())).collect(Collectors.toList());
        List<Branch> branches = branchService.getAll();

        model.addAttribute("vehicleConditions", vehicleConditions);
        model.addAttribute("bodyTypes", bodyTypes);
        model.addAttribute("branches", branches);
        model.addAttribute("fuelTypes", fuelTypes);
        model.addAttribute("post", new Post());
        model.addAttribute("vehicle", new Vehicle());

        return "create-listing";
    }

    @PostMapping(value = "/create-listing")
    public String submitCreateListingForm(@ModelAttribute Post post, @ModelAttribute Vehicle vehicle) {

        post.setVehicle(vehicle);
        System.out.println("created post");
        System.out.println(post);

        //postService.create();

        return "redirect:/";
    }

    @GetMapping(value = "/posts/{postId}")
    public String showEditPostForm(@PathVariable int postId, Model model) {
        Post post = postService.read(postId);

        if(post==null){
            return "not-found";
        }

        model.addAttribute("post", post);

        return "edit-post";
    }

    @PostMapping(value = "/edit-post")
    public String submitEditPostForm(@ModelAttribute Post post) {
        System.out.println("edited post");
        System.out.println(post);
        postService.update(post);
        return "redirect:/search";
    }


    @PostMapping(value = "posts/{postId}")
    public String deletePost(@PathVariable int postId) {

        boolean result = postService.delete(postId, "john@gmail.com");
        System.out.println(result);
        if(result) {
            return "redirect:/search";
        }

        return "not-found";

    }
}
