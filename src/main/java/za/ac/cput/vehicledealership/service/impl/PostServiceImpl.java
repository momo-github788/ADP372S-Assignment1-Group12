package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.service.PostService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post read(String postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    @Override
    public Post update(Post post) {
        if(this.postRepository.existsById(post.getPostId())) {
            return this.postRepository.save(post);
        }
        return null;
    }

    @Override
    public boolean delete(String postId) {
        if(this.postRepository.existsById(postId)) {
            this.postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Post> getAll() {
        return postRepository.findAll().stream().collect(Collectors.toSet());
    }
}
