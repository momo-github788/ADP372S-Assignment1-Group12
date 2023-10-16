package za.ac.cput.vehicledealership.controller;
/* AddonsControllerTest.java
   Test class for User controller class
   Author: George Tapiwa Charimba (220073465)
   Date: 17 June 2023
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.AddonsFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddonsControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Addon addons = AddonsFactory.createAddons("Sunroof", "Panoramic", LocalDateTime.now(), AddonType.DETAILING, 1500, 12, 5000);

    private final String BASE_URL = "http://localhost:8080/addons";
    private RestTemplate restTemplate = new RestTemplate();

    private static int addonId;

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
        return new HttpEntity<>(object, authConfig.getAuthForUser());
    }

    @Test
    @Order(1)
    void create() {

        String url = BASE_URL + "/create?type=user";

        HttpEntity<?> addonEntity = performPostRequest(addons);

        ResponseEntity<Addon> postResponse = restTemplate.postForEntity(url, addonEntity, Addon.class);
        Addon savedAddons = postResponse.getBody();

        System.out.println("Saved data: " + savedAddons);
        assertNotNull(savedAddons);

        addonId = savedAddons.getAddonId();
        System.out.println("addon id " + addonId);
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + addonId + "?type=user";
        System.out.println("URL: " + url);

        ResponseEntity<Addon> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForUser())
                .build(),Addon.class);

        Addon readAddons = getResponse.getBody();
        assertEquals(addonId, readAddons.getAddonId());

        System.out.println("Read: " + readAddons);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=user";

        Addon updateAddons = new Addon.Builder()
                .copy(addons)
                .setName("Towbar")
                .build();

        updateAddons.setAddonId(addonId);

        HttpEntity<?> addonEntity = performPostRequest(updateAddons);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + addonEntity);
        ResponseEntity<Addon> response = restTemplate.postForEntity(url, addonEntity, Addon.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {

        authConfig.getAuthForUser();
        String url = BASE_URL + "/delete/" + addonId + "?type=user";
        System.out.println("URL: " + url);

        HttpEntity<?> addonEntity = performPostRequest(addons);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, addonEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/all?type=user";
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(authConfig.getAuthForUser());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}