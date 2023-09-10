package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.*;
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
        // replace wwith principal
        Post createdPost = postService.create(post,"john@gmail.com");
        if(createdPost == null) {
            return ResponseEntity.badRequest().body("Error creating record.. Please try again later");
        }
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Post post = postService.read(id);

        if(post == null) {
            return ResponseEntity.badRequest().body("Post with id " + id + " not found.");
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/all")
    public List<Post> getAll( @RequestParam(required = false) String title) {
        return postService.getAll(title);
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
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean status = postService.delete(id, "john@gmail.com");

        if(status) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body("Post deleted successfully.");
    }
}
