package za.ac.cput.vehicledealership.service;

/*  PostServiceImplTest.java
    Test class for PostServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostServiceImplTest {

    @Autowired
    private PostServiceImpl postService;
    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static Employee employee = EmployeeFactory.createEmployee(name, "Password123", "Mary@gmail.com");
    private static City city = CityFactory.createCity("Cape Town");

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", city,
            "7850", "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true, employee, employee.getEmailAddress());

    @Order(1)
    @Test
    void create() {
        Post createdPost = postService.create(post, post.getPostCreatorEmail());
        assertNotNull(createdPost);
        System.out.println("Create: " + createdPost);
    }

    @Order(2)
    @Test
    void read() {
        Post readPost = postService.read(post.getPostId());
        assertNotNull(readPost);
        System.out.println("Read: " + readPost);
    }

    @Order(3)
    @Test
    void update() {
        Post updatedPost = new Post.Builder()
            .copy(post)
            .setPrice(199999.99)
            .build();
        assertNotNull(postService.update(updatedPost));
        System.out.println("Update: " + updatedPost);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = postService.delete(post.getPostId(), post.getPostCreatorEmail());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(postService.getAll());
        assertEquals(1, postService.getAll().size());
    }
}