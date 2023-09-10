package za.ac.cput.vehicledealership.controller.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
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
            return "not-found";
        }

        model.addAttribute("title", title);
        model.addAttribute("postList", posts);
        return "post-listings";
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
