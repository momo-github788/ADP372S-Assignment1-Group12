package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.service.impl.ImageUploadServiceImpl;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {


    private PostServiceImpl postService;
    private ImageUploadServiceImpl imageUploadService;

    @Autowired
    public PostController(PostServiceImpl postService, ImageUploadServiceImpl imageUploadService) {
        this.postService = postService;
        this.imageUploadService = imageUploadService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestPart(required = false, value = "image")  MultipartFile image, @RequestPart(value = "post") Post post, Principal principal) {
        Post createdPost = postService.create(post, principal.getName());

        // If there is a post and there is an image added to request
        if(createdPost != null) {
           if(image != null) {
               System.out.println("there is an image added to request");
               try {
                   imageUploadService.uploadImage(image.getBytes(), createdPost.getPostId());
                   return ResponseEntity.ok(createdPost);
               }catch (IOException e) {
                   return ResponseEntity.badRequest().body("Error uploading image. Please try again");
               }
           } else {
               System.out.println("there is NO image added to request");
               return ResponseEntity.ok(createdPost);
           }
        }

        return ResponseEntity.badRequest().body("Post already exists");
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Post post = postService.read(id);

        if(post == null) {
            return ResponseEntity.badRequest().body("Post with id " + id + " not found.");
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/all/employee")
    public List<Post> getAll(Principal principal) {
        System.out.println("princpal " + principal.getName());
        return postService.getAllByEmailAddress(principal.getName());
    }

    @GetMapping("/search")
    public List<Post> getAll(@RequestParam(required = false) String title) {
        return postService.getAll(title);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestPart(required = false, value = "image")  MultipartFile image, @RequestPart(value = "post") Post post, Principal principal) {

        Post updatedPost = postService.update(post, image, principal.getName());

        if(updatedPost != null) {
            return ResponseEntity.ok(updatedPost);
        }


        return ResponseEntity.badRequest().body("Post already exists");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id, Principal principal) {
        boolean status = postService.delete(id, principal.getName());

        if(status) {
            // 204 No Content for successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // 404 Not Found for unsuccessful deletion
            return ResponseEntity.notFound().build();
        }
    }
}
