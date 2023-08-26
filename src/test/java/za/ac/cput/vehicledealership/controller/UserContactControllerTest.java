//package za.ac.cput.vehicledealership.controller;
///* AddonsControllerTest.java
//   Test class for UserContact controller class
//   Author: George Tapiwa Charimba (220073465)
//   Date: 17 June 2023
// */
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.factory.UserContactFactory;
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class UserContactControllerTest {
//
//    private static Contact contact = ContactFactory.createContact("062930280", "geocharimba@gmail.com");
//    private static UserContact userContact = UserContactFactory.createUserContact(contact);
//
//    private final String BASE_URL = "http://localhost:8080/userContact";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    @Order(1)
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<UserContact> postResponse = restTemplate.postForEntity(url, userContact, UserContact.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        UserContact savedUserContact = postResponse.getBody();
//
//        System.out.println("Saved data: " + savedUserContact);
//        assertEquals(userContact.getUserId(), savedUserContact.getUserId());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + userContact.getUserId();
//        System.out.println("URL: " + url);
//        ResponseEntity<UserContact> getResponse = restTemplate.getForEntity(url, UserContact.class);
//        UserContact readUserContact = getResponse.getBody();
//        assertEquals(userContact.getUserId(), readUserContact.getUserId());
//
//        System.out.println("Read: " + readUserContact);
//
//
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//        UserContact updateUserContact = new UserContact.Builder()
//                .copy(userContact)
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updateUserContact);
//        ResponseEntity<UserContact> response = restTemplate.postForEntity(url, updateUserContact, UserContact.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + userContact.getUserId();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//
//    }
//
//    @Test
//    @Order(4)
//    void getAll() {
//        String url = BASE_URL + "/all";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("Show all");
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//
//}