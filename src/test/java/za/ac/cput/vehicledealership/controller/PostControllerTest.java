package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@Disabled
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @Autowired
    private BranchServiceImpl branchService;

    private static Name name = NameFactory.createName("John", "", "Doe");
    private static Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com", "Password123");
    private static RegisterDTO request = new RegisterDTO(name, employee.getEmailAddress(), null);

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
            7850, "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true, employee, request.getEmailAddress());


    private final String BASE_URL = "http://localhost:8080/post";
    private RestTemplate restTemplate = new RestTemplate();

    private static int postId;

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> employeeResponse = restTemplate.postForEntity("http://localhost:8080/employee/create", employee, Employee.class);

        Branch createdBranch = branchService.create(branch);
        System.out.println(employeeResponse);
        employee.setPosts(List.of(post));

        post.setBranch(createdBranch);
        ResponseEntity<Post> postResponse = restTemplate.postForEntity(url, post, Post.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Post savedPost = postResponse.getBody();

        System.out.println("Saved data: " + savedPost);
        assertNotNull(savedPost);

        postId = savedPost.getPostId();
    }


    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + postId;
        System.out.println("URL: " + url);
        ResponseEntity<Post> getResponse = restTemplate.getForEntity(url, Post.class);
        Post readPost = getResponse.getBody();

        System.out.println(readPost);
        assertEquals(postId, readPost.getPostId());

        System.out.println("Read: " + readPost);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Post updatePost = new Post.Builder()
                .copy(post)
                .setDescription("Car is in terrible condition. Behind on license")
                .build();

        updatePost.setPostId(postId);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updatePost);
        ResponseEntity<Post> response = restTemplate.postForEntity(url, updatePost, Post.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + postId;
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }



}