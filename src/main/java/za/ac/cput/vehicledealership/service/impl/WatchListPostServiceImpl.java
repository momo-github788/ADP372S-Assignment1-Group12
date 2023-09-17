/*  WatchListPostServiceImpl.java
    Implementation of the WatchListPostService
    Author: Muhammed Luqmaan Hoosain (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.WatchListPostFactory;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.repository.WatchListPostRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WatchListPostServiceImpl {


    private WatchListPostRepository watchListPostRepository;
    private UserServiceImpl userService;
    private PostRepository postRepository;

    @Autowired
    public WatchListPostServiceImpl(WatchListPostRepository watchListPostRepository, UserServiceImpl userService, PostRepository postRepository) {
        this.watchListPostRepository = watchListPostRepository;
        this.userService = userService;
        this.postRepository = postRepository;
    }


    public WatchListPost create(int postId, String emailAddress) {
        User user = userService.readByEmailAddress(emailAddress);
        Post post = postRepository.findByPostId(postId);

        if(post == null) {
            throw new RuntimeException("Post with id " + postId + " does not exist");
        }

        WatchListPost watchlistPost = WatchListPostFactory.createWatchListPost(post.getPostId(), user.getUserId());
        return watchListPostRepository.save(watchlistPost);
    }

    public boolean delete(int postId, String emailAddress) {
        User user = userService.readByEmailAddress(emailAddress);
        WatchListPost watchlistPost = watchListPostRepository.findFirstByPostIdAndUserId(postId, user.getUserId());

        if (watchlistPost == null) {
            return false;
        }

        watchListPostRepository.delete(watchlistPost);
        return true;
    }


    public List<Post> readAllWatchlistPostsForUser(String emailAddress) {

        User user = userService.readByEmailAddress(emailAddress);

        List<WatchListPost> watchListPostIdList = watchListPostRepository.findAllByUserId(user.getUserId());

        List<Post> posts = postRepository.findAllByPostIdIn(watchListPostIdList.stream()
                .map(post -> post.getPostId())
                .collect(Collectors.toList())
        );

        System.out.println("user watchlists");
        System.out.println(posts);

        if (posts.isEmpty()) {
            return Collections.EMPTY_LIST;
        }


        return posts;
    }
}
