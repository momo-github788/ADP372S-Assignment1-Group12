package za.ac.cput.vehicledealership.service.impl;

/*  PostServiceImpl.java
    Implementation of PostService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.repository.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl {

    private ImageUploadRepository imageUploadRepository;
    private PostRepository postRepository;
    private EmployeeServiceImpl employeeService;
    private VehicleRepository vehicleRepository;
    private EmployeeRepository employeeRepository;
    private ContactDetailServiceImpl contactDetailService;
    private VehicleServiceImpl vehicleService;
    private BranchServiceImpl branchService;
    private BranchRepository branchRepository;


    public PostServiceImpl() {

    }

    @Autowired
    public PostServiceImpl(PostRepository postRepository, VehicleRepository vehicleRepository, ImageUploadRepository imageUploadRepository, BranchRepository branchRepository, BranchServiceImpl branchService, VehicleServiceImpl vehicleService, EmployeeRepository employeeRepository, EmployeeServiceImpl employeeService, ContactDetailServiceImpl contactDetailService) {
        this.postRepository = postRepository;
        this.imageUploadRepository = imageUploadRepository;
        this.branchService = branchService;
        this.branchRepository = branchRepository;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
        this.vehicleRepository = vehicleRepository;
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

        System.out.println("Request");
        System.out.println(post);
        Branch branch = branchService.read(post.getBranch().getBranchId());

        if (branch == null) {
            throw new IllegalArgumentException("BRANCH DOES NOT EXIST");
        }

        System.out.println("Found emp");
        System.out.println(employee);

        System.out.println("Found branch");
        System.out.println(branch);

        Vehicle vehicle = vehicleService.create(post.getVehicle());

        post.setPostCreatorEmail(emailAddress);
        post.setEmployee(employee);
        post.setActive(true);
        post.setVehicle(vehicle);
        post.setBranch(branch);

//            post.setBranch();

        if (postRepository.existsByTitle(post.getTitle())) {
            System.out.println("post already exist");
            return null;
        }

        branchRepository.save(branch);
        employeeRepository.save(employee);

        postRepository.save(post);
        return post;
    }


    public Post read(int postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    public Post update(Post post, MultipartFile file, String emailAddress) {
        System.out.println("Finding employee by " + emailAddress);
        Employee employee = employeeService.readByEmail(emailAddress);


        if (this.postRepository.existsById(post.getPostId())) {
            System.out.println("post");
            System.out.println(post);

            try {

                ImageUpload imageUpload = imageUploadRepository.findImageUploadByPost(post);
                if (imageUpload != null && file != null) {  // Check if existing file and update with new file
                    System.out.println("this post already has an image.. updating");
                    imageUpload.setData(file.getBytes());

                    post.setImageUpload(imageUpload);
                    imageUploadRepository.save(imageUpload);

                } else if(file != null) {// New file added and save the new file
                    System.out.println("a new file was added..");
                    ImageUpload newImage = new ImageUpload();
                    newImage.setPost(post);
                    newImage.setData(file.getBytes());

                    post.setImageUpload(newImage);
                    imageUploadRepository.save(newImage);

                } else { // No new files added, file might have been deleted to update the value in Post to reflect it
                    System.out.println("no changes made to image");
                    System.out.println(imageUpload);
                    post.setImageUpload(imageUpload);
                }


                post.setPostCreatorEmail(emailAddress);
                post.setActive(true);
                post.setEmployee(employee);
                return this.postRepository.save(post);
            } catch (IOException e) {
                System.out.println("error uploading");
                e.printStackTrace();
            }


        }

        return null;

    }


    public boolean delete(int postId, String emailAddress) {

        Post post = postRepository.findById(postId).orElse(null);


        if (post != null) {

            System.out.println("Found post to delete");
            System.out.println(post);
            if (post.getImageUpload() != null) {
                System.out.println("this post has an image" + post.getImageUpload().getId());
                imageUploadRepository.deleteById(post.getImageUpload().getId());
            }

            vehicleService.delete(post.getVehicle().getVehicleId());
            postRepository.deleteById(postId);

            return true;
        }
        return false;
    }


    public List<Post> getAllByEmailAddress(String emailAddress) {
        return postRepository.findAllByPostCreatorEmail(emailAddress);
    }


    public List<Post> getAll(String title) {

        if (title != null) {
            return postRepository.findAllByTitleContaining(title);
        }
        return postRepository.findAll();
    }
}
