package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.PostRepository;
import za.ac.cput.vehicledealership.repository.VehicleRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {

    private PostRepository postRepository;
    private EmployeeServiceImpl employeeService;
    private EmployeeRepository employeeRepository;
    private VehicleRepository vehicleRepository;
    private ContactDetailServiceImpl contactDetailService;
    private VehicleServiceImpl vehicleService;

    public PostServiceImpl() {

    }

    @Autowired
    public PostServiceImpl(PostRepository postRepository, VehicleRepository vehicleRepository, VehicleServiceImpl vehicleService, EmployeeRepository employeeRepository, EmployeeServiceImpl employeeService, ContactDetailServiceImpl contactDetailService) {
        this.postRepository = postRepository;
        this.vehicleRepository = vehicleRepository;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.vehicleService = vehicleService;
        this.contactDetailService = contactDetailService;
    }

    public void deleteAll() {
        employeeRepository.deleteAll();
        postRepository.deleteAll();
    }

//
//    User user = userRepository.findUserByEmailAddress(emailAddress);
//        post.setPostCreatorEmail(emailAddress);
//        post.setPostCreatorName(user.getFullName());
//        post.setUser(user);
//        post.setActive(true);
//
//        if(postRepository.existsByTitle(post.getTitle())) {
//        throw new PostAlreadyExistsException("Post with title " + post.getTitle() + " already exists");
//    }
//
//
//        userRepository.save(user);
//        postRepository.save(post);
//        return post;



    public Post create(Post post, String emailAddress) {
        System.out.println("Finding employee by " + emailAddress);
        Employee employee = employeeService.readByEmail(emailAddress);

        System.out.println("Found emp");
        System.out.println(employee);

        Vehicle vehicle = vehicleService.create(post.getVehicle());

        post.setPostCreatorEmail(emailAddress);
        post.setEmployee(employee);
        post.setActive(true);
        post.setVehicle(vehicle);
//            post.setBranch();

        if(postRepository.existsByTitle(post.getTitle())) {
            throw new RuntimeException("Post with title " + post.getTitle() + " already exists");
        }

        employeeRepository.save(employee);
        vehicleRepository.save(vehicle);
        postRepository.save(post);
        return post;
    }

    public Post read(int postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    public Post update(Post post) {
        if(this.postRepository.existsById(post.getPostId())) {
            return this.postRepository.save(post);
        }
        return null;
    }


    public boolean delete(int postId, String emailAddress) {

        Post post = postRepository.findByPostId(postId);

        if(post != null) {

            if(!post.getPostCreatorEmail().equals(emailAddress)) {
                throw new RuntimeException("Post " + post.getTitle() + " not found in your account so it cannot be deleted.");
            }
            this.postRepository.deleteById(postId);
            return true;
        }
        return false;
    }


    public List<Post> getAllByEmailAddress(String emailAddress) {
        return postRepository.findAllByPostCreatorEmail(emailAddress);
    }


    public Set<Post> getAll() {
        return postRepository.findAll().stream().collect(Collectors.toSet());
    }
}
