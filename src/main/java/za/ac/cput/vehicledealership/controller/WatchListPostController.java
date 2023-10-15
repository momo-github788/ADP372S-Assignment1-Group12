package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.service.WatchListPostService;
import za.ac.cput.vehicledealership.service.impl.WatchListPostServiceImpl;


import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/watchlist")
@CrossOrigin
public class WatchListPostController {

    @Autowired
    private WatchListPostServiceImpl watchListPostService;

    @GetMapping("/{postId}")
    public WatchListPost create(@PathVariable int postId, Principal principal) {
        System.out.println("princiapl to create watchlist " + principal.getName());
        return watchListPostService.create(postId, principal.getName());
    }

    @GetMapping("read/{postId}")
    public ResponseEntity<?> get(@PathVariable int postId, Principal principal) {
        WatchListPost watchListPost = watchListPostService.readWatchlistPostForUserByPostId(principal.getName(), postId);

        if (watchListPost == null){
            return ResponseEntity.badRequest().body("Watchlist post with id " + postId + " not found");
        }
        return ResponseEntity.ok(watchListPost);
    }

    @GetMapping("/all")
    public List<Post> getAll(Principal principal) {
        return watchListPostService.readAllWatchlistPostsForUser(principal.getName());
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id, Principal principal) {
        return watchListPostService.delete(id, principal.getName());
    }
}
