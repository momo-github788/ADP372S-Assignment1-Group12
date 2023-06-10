package za.ac.cput.vehicledealership.repository.impl;

/*  PostRepositoryImpl.java
    Implementation of IPostRepository
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.repository.PostRepository;

import java.util.HashSet;
import java.util.Set;

public class PostRepositoryImpl implements PostRepository {

    private static PostRepositoryImpl postRepository = null;
    private Set<Post> postDB = null;

    private PostRepositoryImpl() {
        this.postDB = new HashSet<>();
    }

    public static PostRepositoryImpl getPostRepository() {
        if(postRepository == null) {
            postRepository = new PostRepositoryImpl();
        }
        return postRepository;
    }

    @Override
    public Post create(Post post) {
        boolean success = postDB.add(post);

        if(!success) {
            return null;
        }
        return post;
    }

    @Override
    public Post read(String postId) {
        return postDB
            .stream()
            .filter(post -> post.getPostId().equals(postId))
            .findAny()
            .orElse(null);
            //.orElseThrow(() -> new RuntimeException("Post does not exist"));
    }

    @Override
    public Post update(Post post) {
        Post oldPost = read(post.getPostId());

        if(oldPost != null) {
            postDB.remove(oldPost);
            postDB.add(post);
            return post;

        }
        return null;
    }

    @Override
    public boolean delete(String postId) {
        Post post = read(postId);

        if(post == null) {
            return false;
        }

        postDB.remove(post);
        return true;
    }

    @Override
    public Set<Post> getAll() {
        return postDB;
    }
}
