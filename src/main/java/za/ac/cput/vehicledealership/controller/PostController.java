package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.service.PostService;
import za.ac.cput.vehicledealership.service.PostService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @GetMapping("/read/{id}")
    public Post get(@PathVariable String id) {
        return postService.read(id);
    }

    @GetMapping("/all")
    public Set<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping("/update")
    public Post update(@RequestBody Post post) {
        return postService.update(post);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id) {
        return postService.delete(id);
    }
}
