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
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.PostFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.service.impl.PostServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostServiceImplTest {

    private static PostServiceImpl postService = PostServiceImpl.getPostService();

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
            "7850", "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true);

    @Order(1)
    @Test
    void create() {
        Post createdPost = postService.create(post);
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
        boolean success = postService.delete(post.getPostId());

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