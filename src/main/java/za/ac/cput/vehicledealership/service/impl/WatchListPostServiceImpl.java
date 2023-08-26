/*  WatchListPostServiceImpl.java
    Implementation of the WatchListPostService
    Author: Muhammed Luqmaan Hoosain (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.WatchListPostFactory;
import za.ac.cput.vehicledealership.repository.ContactRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.repository.WatchListPostRepository;
import za.ac.cput.vehicledealership.service.UserContactService;
import za.ac.cput.vehicledealership.service.WatchListPostService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WatchListPostServiceImpl {


    private WatchListPostRepository watchListPostRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;
    private UserContactServiceImpl userContactService;

    @Autowired
    public WatchListPostServiceImpl(WatchListPostRepository watchListPostRepository, UserRepository userRepository, PostRepository postRepository,
                            UserContactServiceImpl userContactService) {
        this.watchListPostRepository = watchListPostRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userContactService = userContactService;
    }





//    public WatchListPost create(String postId, String emailAddress) {
//        User user = userRepository.findUserByContact_EmailAddress(emailAddress);
//        Post post = postRepository.findPostByPostId(postId);
//
//        WatchListPost watchlistPost = WatchListPostFactory.createWatchListPost(post.getPostId(), user.getUserId());
//
//        if (emailAddress.equals(post.getPostCreatorEmail())) {
//            throw new RuntimeException("You cannot Watchlist your own post");
//        }
//
//        watchListPostRepository.save(watchlistPost);
//
//        return watchlistPost;
//    }

//    public boolean delete(String watchListPostId, String emailAddress) {
//        User user = userRepository.findUserByContact_EmailAddress(emailAddress);
//        WatchListPost watchlistPost = watchListPostRepository.findFirstByPostIdAndUserId(watchListPostId, user.getUserId());
//
//        if (watchlistPost == null) {
//            return false;
//        }
//
//        watchListPostRepository.delete(watchlistPost);
//        return true;
//    }


//    public List<Post> readAllWatchlistPostsForUser(String userId) {
//        List<Contact> userContacts = userContactService.readAllContactsForUser(userId);
//
//        User user = userRepository.f
//
//        List<WatchListPost> watchListPostIdList = watchListPostRepository.findAllByUserId(user.getUserId());
//
//        List<Post> posts = postRepository.findAllByPostIdIn(watchListPostIdList.stream()
//                .map(post -> post.getPostId())
//                .collect(Collectors.toList())
//        );
//
//        if (posts.isEmpty()) {
//            return Collections.EMPTY_LIST;
//        }
//
//
//        return posts;
//    }
}
