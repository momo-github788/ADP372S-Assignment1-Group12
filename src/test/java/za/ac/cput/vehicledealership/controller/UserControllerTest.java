package za.ac.cput.vehicledealership.controller;

/* UserControllerTest.java
   Test class for User controller class
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static User user = UserFactory.createUser(name, "P@ssword123", "mary@gmail.com");

    private final String BASE_URL = "http://localhost:8080/user";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void create() {
            String url = BASE_URL + "/create";
            ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
            assertNotNull(postResponse);
            assertNotNull(postResponse.getBody());

            User savedUser = postResponse.getBody();

            System.out.println("Saved data: " + savedUser);
            assertEquals(1, savedUser.getUserId());
    }
    @Test
    @Order(2)
    void read(){
        String url = BASE_URL + "/read/" + 1;
        System.out.println("URL: " + url);
        ResponseEntity<User> getResponse = restTemplate.getForEntity(url, User.class);
        User readUser = getResponse.getBody();
        assertEquals(1, readUser.getUserId());

        System.out.println("Read: " + readUser);
    }
    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        User updateUser = new User.UserBuilder()
                .copy(user)
                .setPassword("JC5678")
                .build();

        updateUser.setUserId(1);
        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateUser);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updateUser, User.class);
        assertNotNull(response.getBody());
    }


    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + 1;
        System.out.println("URL: " + url);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
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