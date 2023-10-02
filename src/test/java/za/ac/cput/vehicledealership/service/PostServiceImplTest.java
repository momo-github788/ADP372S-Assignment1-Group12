package za.ac.cput.vehicledealership.service;

/*  PostServiceImplTest.java
    Test class for PostServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;
import za.ac.cput.vehicledealership.service.impl.EmployeeServiceImpl;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;
import za.ac.cput.vehicledealership.service.impl.VehicleServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private VehicleServiceImpl vehicleService;

    @Autowired
    private BranchServiceImpl branchService;
    @Autowired
    private EmployeeServiceImpl employeeService;


    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static Employee employee = EmployeeFactory.createEmployee( name, "john@gmail.com", "Password123");

    private static RegisterDTO request = new RegisterDTO(name, employee.getEmailAddress(), employee.getPassword(), null);

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
            7850, "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true, employee, request.getEmailAddress());

    @Order(1)
    @Test
    void create() {
        Branch createdBranch = branchService.create(branch);
        System.out.println("created branch");
        System.out.println(createdBranch);
        post.setBranch(createdBranch);


        assertNotNull(postService.create(post, post.getPostCreatorEmail()));
    }

    @Order(2)
    @Test
    void read() {

        Post readPost = postService.read(post.getPostId());
        assertNotNull(readPost);
        System.out.println("Read: " + readPost);
        postService.deleteAll();
    }

    @Order(3)
    @Test
    void update() {
        Post updatedPost = new Post.Builder()
            .copy(post)
            .setPrice(199999.99)
            .build();

        System.out.println(updatedPost);

        assertNull(postService.update(updatedPost, null, employee.getEmailAddress()));
        System.out.println("Update: " + updatedPost);

    }

    @Order(5)
    @Test
    void deleteAll() {
        vehicleService.delete(vehicle.getVehicleId());
        branchService.delete(branch.getBranchId());
        postService.delete(post.getPostId(), "john@gmail.com");

    }


    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(postService.getAll(null));
    }
}