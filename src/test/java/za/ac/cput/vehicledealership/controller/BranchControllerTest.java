package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BranchControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();
    private static Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", 7626, "Western Cape");
    private static Branch branch  = BranchFactory.createBranch("Paarl branch",2008,location);
    private final String BASE_URL = "http://localhost:8080/branch";
    private RestTemplate restTemplate = new RestTemplate();

    private static int branchId;

    @BeforeEach
    void setUp() {
        if(!userRepository.existsByEmailAddress(TestAuthConfig.USER_NAME)) {
            authConfig.registerUser(new RegisterRequest(NameFactory.createName("Sarah", "", "Doe"), TestAuthConfig.USER_NAME, TestAuthConfig.PASSWORD));
        }
        if(!employeeRepository.existsByEmailAddress(TestAuthConfig.EMPLOYEE_NAME)) {
            authConfig.registerEmployee(new RegisterRequest(NameFactory.createName("John", "", "Doe"), TestAuthConfig.EMPLOYEE_NAME, TestAuthConfig.PASSWORD));

        }
    }


    // Use for POST requests where employees can access endpoints (ADMIN ROLE)
    private HttpEntity<?> performPostRequest(Object object) {
        // This is an employee logged in
        return new HttpEntity<>(object, authConfig.getAuthForEmployee());
    }


    @Test
    @Order(1)
    void create() {

        HttpEntity<?> branchEntity = performPostRequest(branch);

        String url = BASE_URL + "/create?type=employee";

        ResponseEntity<Branch> postResponse = restTemplate.postForEntity(url, branchEntity, Branch.class);
        Branch savedBranch = postResponse.getBody();

        System.out.println("Saved data: " + savedBranch);
        assertNotNull(savedBranch);

        branchId = savedBranch.getBranchId();
        System.out.println("branch id " + branchId);
    }

    @Test
    @Order(2)
    void read() throws Exception {


        String url = BASE_URL + "/read/" + branchId + "?type=employee";
        System.out.println("URL: " + url);
        // Here im adding the header so it knows the Employee is logged in and will perform the request
        ResponseEntity<Branch> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForEmployee())
                .build(), Branch.class);

        Branch readBranch = getResponse.getBody();
        assertEquals(branchId, readBranch.getBranchId());

        System.out.println("Read: " + readBranch);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Location location = LocationFactory.createLocation(46664, "Marvel", "Durban", 8200, "Western cape");
        Branch updateBranch = new Branch.BranchBuilder()
                .copy(branch)
                .setLocation(location)
                .build();

        updateBranch.setBranchId(branchId);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateBranch);
        ResponseEntity<Branch> response = restTemplate.postForEntity(url, updateBranch, Branch.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + branchId + "?type=employee";
        System.out.println("URL: " + url);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode()); // 204 No Content for successful deletion
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

