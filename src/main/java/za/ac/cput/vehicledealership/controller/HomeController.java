package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Controller
public class HomeController {


    private PostServiceImpl postService;

    @Autowired
    public HomeController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHome(Model model) {
        Set<Post> postList = postService.getAll();

        model.addAttribute("postList", postList);
        return "demo";
    }
}
