package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.service.WatchListPostService;
import za.ac.cput.vehicledealership.service.impl.WatchListPostServiceImpl;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/watchlist")
public class WatchListPostController {

    @Autowired
    private WatchListPostServiceImpl watchListPostService;

    @PostMapping("/create")
    public WatchListPost create(@RequestBody WatchListPost watchListPost) {
        return watchListPostService.create(watchListPost.getPostId(), "user@gmail.com");
    }

    @GetMapping("/all")
    public List<Post> getAll() {
        return watchListPostService.readAllWatchlistPostsForUser("user@gmail.com");
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return watchListPostService.delete(id, "user@gmail.com");
    }
}
