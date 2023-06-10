package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.repository.impl.PostRepositoryImpl;
import za.ac.cput.vehicledealership.service.PostService;
import za.ac.cput.vehicledealership.domain.Post;

import java.util.Set;

public class PostServiceImpl implements PostService {

    private static PostServiceImpl postService = null;
    private PostRepositoryImpl postRepository = null;

    public PostServiceImpl() {
        this.postRepository = PostRepositoryImpl.getPostRepository();
    }

    public static PostServiceImpl getPostService() {
        if(postService == null) {
            postService = new PostServiceImpl();
        }
        return postService;
    }


    @Override
    public Post create(Post post) {
        return postRepository.create(post);
    }

    @Override
    public Post read(String postId) {
        return postRepository.read(postId);
    }

    @Override
    public Post update(Post post) {
        return postRepository.update(post);
    }

    @Override
    public boolean delete(String postId) {
        return postRepository.delete(postId);
    }

    @Override
    public Set<Post> getAll() {
        return postRepository.getAll();
    }
}
