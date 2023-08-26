//package za.ac.cput.vehicledealership.controller;
//
///* ContactControllerTest.java
//   Test class for Contact controller
//   Author: Junaid Cedrass (219090912)
//   Date: 17 June 2023
// */
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class ContactControllerTest {
//
//    private static Contact contact = ContactFactory.createContact("08245321231", "ashwin2@gmail.com");
//    private final String BASE_URL = "http://localhost:8080/contact";
//    private RestTemplate restTemplate = new RestTemplate();
//    @Test
//    @Order(1)
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url, contact, Contact.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        Contact savedContact = postResponse.getBody();
//
//        System.out.println("Saved data: " + savedContact);
//        assertEquals(contact.getContactNumber(), savedContact.getContactNumber());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + contact.getContactNumber();
//        System.out.println("URL: " + url);
//        ResponseEntity<Contact> getResponse = restTemplate.getForEntity(url, Contact.class);
//        Contact readContact = getResponse.getBody();
//        assertEquals(contact.getContactNumber(), readContact.getContactNumber());
//
//        System.out.println("Read: " + readContact);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//        Contact updateContact = new Contact.ContactBuilder()
//                .copy(contact)
//                .setContactNumber("08245321231")
//                .setEmailAddress("ashwin3@gmail.com")
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updateContact);
//        ResponseEntity<Contact> response = restTemplate.postForEntity(url, updateContact, Contact.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + contact.getContactNumber();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//    }
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
//}