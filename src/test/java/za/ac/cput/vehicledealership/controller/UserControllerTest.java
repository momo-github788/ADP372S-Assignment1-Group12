package za.ac.cput.vehicledealership.controller;

/* UserControllerTest.java
   Test class for User controller class
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @Autowired
    private UserRepository userRepository;


    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static User user = UserFactory.createUser(name, "P@ssword123", "mary@gmail.com");
    private final String AUTH_URL = "http://localhost:8080/auth";
    private final String BASE_URL = "http://localhost:8080/user";
    private RestTemplate restTemplate = new RestTemplate();
    private static int userId;

    private HttpEntity<?> performPostRequest(Object object) {
        // This is a user logged in
        return new HttpEntity<>(object, authConfig.getAuthForUser());
    }



    @BeforeEach
    void setUp() {
        if(!userRepository.existsByEmailAddress(TestAuthConfig.USER_NAME)) {
            authConfig.registerUser(new RegisterRequest(NameFactory.createName("Sarah", "", "Doe"), TestAuthConfig.USER_NAME, TestAuthConfig.PASSWORD));
        }
    }


    @Test
    @Order(1)
    void create() {
        HttpEntity<?> userEntity = performPostRequest(user);

        String url = AUTH_URL + "/user/register";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, userEntity, User.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        User savedUser = postResponse.getBody();

        System.out.println("Saved data: " + savedUser);
        assertNotNull(savedUser);

        userId = savedUser.getUserId();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + userId + "?type=user";
        System.out.println("URL: " + url);
        ResponseEntity<User> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                        .headers(authConfig.getAuthForUser())
                        .build(), User.class);

        User readUser = getResponse.getBody();
        assertEquals(userId, readUser.getUserId());

        System.out.println("Read: " + readUser);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=user";

        Name middleName = NameFactory.createName("Julian");

        User updateUser = new User.UserBuilder()
                .copy(user)
                .setName(middleName)
                .build();

        updateUser.setUserId(userId);

        HttpEntity<?> employeeEntity = performPostRequest(updateUser);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateUser);
        ResponseEntity<User> response = restTemplate.postForEntity(url, employeeEntity, User.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        authConfig.getAuthForUser();
        String url = BASE_URL + "/delete/" + userId + "?type=user";
        System.out.println("URL: " + url);

        HttpEntity<?> employeeEntity = performPostRequest(user);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, employeeEntity, String.class);
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