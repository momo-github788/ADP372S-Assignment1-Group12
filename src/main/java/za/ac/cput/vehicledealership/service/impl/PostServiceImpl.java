package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.service.PostService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {

    private PostRepository postRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, EmployeeRepository employeeRepository) {
        this.postRepository = postRepository;
        this.employeeRepository = employeeRepository;
    }


//    public Post create(Post post, String emailAddress) {
//        Employee employee = employeeRepository.findEmployeeByEmailAddress(emailAddress);
//        post.setPostCreatorEmail(emailAddress);
//        post.setEmployee(employee);
//        post.setActive(true);
//
//        if(postRepository.existsByTitle(post.getTitle())) {
//            throw new RuntimeException("Post with title " + post.getTitle() + " already exists");
//        }
//
//        employeeRepository.save(employee);
//        postRepository.save(post);
//        return post;
//
//    }

    public Post read(String postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    public Post update(Post post) {
        if(this.postRepository.existsById(post.getPostId())) {
            return this.postRepository.save(post);
        }
        return null;
    }


    public boolean delete(String postId, String emailAddress) {

        Post post = postRepository.findPostByPostId(postId);

        if(post != null) {

            if(!post.getPostCreatorEmail().equals(emailAddress)) {
                throw new RuntimeException("Post " + post.getTitle() + " not found in your account so it cannot be deleted.");
            }
            this.postRepository.deleteById(postId);
            return true;
        }
        return false;
    }

    public Set<Post> getAll() {
        return postRepository.findAll().stream().collect(Collectors.toSet());
    }
}
