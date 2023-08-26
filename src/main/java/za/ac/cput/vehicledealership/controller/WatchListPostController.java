package za.ac.cput.vehicledealership.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.service.WatchListPostService;
import za.ac.cput.vehicledealership.service.impl.WatchListPostServiceImpl;


import java.util.Set;

@RestController
@RequestMapping("/watchListPost")
public class WatchListPostController {

//    @Autowired
//    private WatchListPostServiceImpl watchListPostService;
//
//    @PostMapping("/create")
//    public WatchListPost create(@RequestBody WatchListPost watchListPost) {
//        return watchListPostService.create(watchListPost);
//    }
//
//    @GetMapping("read/{id}")
//    public WatchListPost get(@PathVariable String id) {
//        return watchListPostService.read(id);
//    }
//
//    @GetMapping("/all")
//    public Set<WatchListPost> getAll() {
//        return watchListPostService.getAll();
//    }
//
//    @PostMapping("/update")
//    public WatchListPost update(@RequestBody WatchListPost watchListPost) {
//        return watchListPostService.update(watchListPost);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public boolean delete(@PathVariable String id) {
//        return watchListPostService.delete(id);
//    }
}
