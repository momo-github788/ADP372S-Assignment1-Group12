package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.util.List;

@Controller
public class PostControllerThymeleaf {

    private PostServiceImpl postService;

    @Autowired
    public PostControllerThymeleaf(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/search")
    public String searchAllPosts(Model model, @RequestParam(required = false) String title) {
        System.out.println("Searching by " + title);

        List<Post> posts = postService.getAll(title);
        if(posts.isEmpty()) {
            return "post-listings-empty";
        }

        model.addAttribute("title", title);
        model.addAttribute("postList", posts);
        return "post-listings";
    }
}
