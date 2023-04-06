package za.ac.cput.repository;

/*  PostRepositoryImplTest.java
    Test class for PostRepositoryImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.*;
import za.ac.cput.factory.BranchFactory;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.factory.PostFactory;
import za.ac.cput.factory.VehicleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostRepositoryImplTest {

    private static PostRepositoryImpl postRepository = PostRepositoryImpl.getPostRepository();
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
        Post createdPost = postRepository.create(post);
        assertNotNull(createdPost);
        System.out.println("Create: " + createdPost);
    }

    @Order(2)
    @Test
    void read() {
        Post readPost = postRepository.read(post.getPostId());
        assertNotNull(readPost);
        System.out.println("Read: " + readPost);
    }

    @Order(3)
    @Test
    void update() {
        Post updatedPost = new Post.PostBuilder()
                .copy(post)
                .setDescription("Car is in terrible condition")
                .build();
        assertNotNull(postRepository.update(updatedPost));
        System.out.println("Update: " + updatedPost);


    }

    @Order(5)
    @Test
    void delete() {
        boolean success = postRepository.delete(post.getPostId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(postRepository.getAll());
        assertEquals(1, postRepository.getAll().size());
    }
}

