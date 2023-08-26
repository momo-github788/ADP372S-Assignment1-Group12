package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.service.PostService;
import za.ac.cput.vehicledealership.service.PostService;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Post post) {
        Post createdPost = postService.update(post);
        if(createdPost == null) {
            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
        }
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Post post = postService.read(id);

        if(post == null) {
            return ResponseEntity.badRequest().body("Post with id " + id + " not found.");
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/all")
    public Set<Post> getAll() {
        return postService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Post post) {
        Post updatedPost = postService.update(post);
        if(updatedPost == null) {
            return ResponseEntity.badRequest().body("Error updating record.. Please try again later");
        }
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        boolean status = postService.delete(id, "john@gmail.com");

        if(!status) {
            return ResponseEntity.badRequest().body("Post " + id + " deleted successfully.");
        }
        return ResponseEntity.badRequest().body("Post deleted successfully.");
    }
}
