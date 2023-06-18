package za.ac.cput.vehicledealership.controller;

/* UserControllerTest.java
   Test class for User controller class
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    static  LocalDate date = LocalDate.of(2002, 10, 29);
    static Contact contact = ContactFactory.createContact("0218765231","jc10@gmail.com");
    private static User user = UserFactory.createUser("Junaid", "Cedrass", date, "JC1234",contact);
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
        assertEquals(user.getUserId(),savedUser.getUserId());
    }
    @Test
    @Order(2)
    void read(){
        String url = BASE_URL + "/read/" + user.getUserId();
        System.out.println("URL: " + url);
        ResponseEntity<User> getResponse = restTemplate.getForEntity(url, User.class);
        User readUser = getResponse.getBody();
        assertEquals(user.getUserId(), readUser.getUserId());

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
        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateUser);
        ResponseEntity<User> response = restTemplate.postForEntity(url, updateUser, User.class);
        assertNotNull(response.getBody());
    }


    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + user.getUserId();
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