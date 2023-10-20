package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.service.impl.BranchServiceImpl;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@Disabled
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostControllerTest {

    @Autowired
    private BranchServiceImpl branchService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Name name = NameFactory.createName("John", "", "Doe");
    private static Employee employee = EmployeeFactory.createEmployee(name, "employee@gmail.com", "Password123");
    private static RegisterDTO request = new RegisterDTO(name, employee.getEmailAddress(), null);

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
            7850, "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Csape town branch", 2017, location);

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true, employee, request.getEmailAddress());


    private final String BASE_URL = "http://localhost:8080/post";
    private RestTemplate restTemplate = new RestTemplate();

    private static int postId;

    @BeforeEach
    void setUp() {
        if(!userRepository.existsByEmailAddress(TestAuthConfig.USER_NAME)) {
            authConfig.registerUser(new RegisterRequest(NameFactory.createName("Sarah", "", "Doe"), TestAuthConfig.USER_NAME, TestAuthConfig.PASSWORD));
        }
        if(!employeeRepository.existsByEmailAddress(TestAuthConfig.EMPLOYEE_NAME)) {
            authConfig.registerEmployee(new RegisterRequest(NameFactory.createName("John", "", "Doe"), TestAuthConfig.EMPLOYEE_NAME, TestAuthConfig.PASSWORD));

        }
    }

    private HttpEntity<?> performPostRequest(Object object) {
        // This is an employee logged in
        return new HttpEntity<>(object, authConfig.getAuthForEmployee());
    }

    @Test
    @Order(1)
    void create() {
        Branch createdBranch = branchService.create(branch);
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
        parameters.add("post", new FileSystemResource("src/main/resources/create_post.json")); // load file into parameter

        String url = BASE_URL + "/create?type=employee";
        employee.setPosts(List.of(post));

        post.setBranch(createdBranch);

        ResponseEntity<Post> postResponse = restTemplate.postForEntity(url,
                new HttpEntity<>(parameters, authConfig.getAuthForEmployeeCreatePost()),
                Post.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Post savedPost = postResponse.getBody();

        System.out.println("Saved data: " + savedPost);
        assertNotNull(savedPost);

        postId = savedPost.getPostId();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + postId + "?type=employee";
        System.out.println("URL: " + url);
        ResponseEntity<Post> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                        .headers(authConfig.getAuthForEmployee())
                        .build(), Post.class);
        Post readPost = getResponse.getBody();

        System.out.println(readPost);
        assertEquals(postId, readPost.getPostId());

        System.out.println("Read: " + readPost);


    }


    @Test
    @Order(4)
    void delete() {
        authConfig.getAuthForEmployee();
        String url = BASE_URL + "/delete/" + postId + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> postEntity = performPostRequest(post);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, postEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion);

    }

    @Test
    @Order(3)
    void getAll() {
        String url = BASE_URL + "/search";
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(authConfig.getAuthForEmployee());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }



}