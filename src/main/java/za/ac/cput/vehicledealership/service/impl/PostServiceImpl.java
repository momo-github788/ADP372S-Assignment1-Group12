package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.service.EmployeeContactService;
import za.ac.cput.vehicledealership.service.EmployeeService;
import za.ac.cput.vehicledealership.service.PostService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {

    private PostRepository postRepository;
    private EmployeeServiceImpl employeeService;
    private EmployeeContactServiceImpl employeeContactService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, EmployeeServiceImpl employeeService, EmployeeContactServiceImpl employeeContactService) {
        this.postRepository = postRepository;
        this.employeeService = employeeService;
        this.employeeContactService = employeeContactService;
    }


    public Post create(Post post, String employeeNumber) {
        Employee employee = employeeService.read(employeeNumber);

        System.out.println("contact list");
        List<Contact> contactList = employeeContactService.readAllContactsForEmployee(employeeNumber);

        System.out.println(contactList);
        Contact email = contactList.stream()
                .filter(i -> i.getContactType().equals(ContactType.EMAIL))
                .findFirst().orElse(null);

        System.out.println(email);
        post.setPostCreatorEmail(email.getValue());
        post.setEmployee(employee);
        post.setActive(true);

        if(postRepository.existsByTitle(post.getTitle())) {
            throw new RuntimeException("Post with title " + post.getTitle() + " already exists");
        }

        //employeeRepository.save(employee);
        postRepository.save(post);
        return post;

    }

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
