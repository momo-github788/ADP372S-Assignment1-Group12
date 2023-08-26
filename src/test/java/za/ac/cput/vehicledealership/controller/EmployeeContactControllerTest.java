//package za.ac.cput.vehicledealership.controller;
///* EmployeeContactControllerTest.java
//   Test class for EmployeeContact controller class
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
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.domain.EmployeeContact;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.factory.EmployeeContactFactory;
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class EmployeeContactControllerTest {
//    private static Contact contact = ContactFactory.createContact("062930280", "geocharimba@gmail.com");
//    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(contact);
//
//    private final String BASE_URL = "http://localhost:8080/employeeContact";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    @Order(1)
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<EmployeeContact> postResponse = restTemplate.postForEntity(url, employeeContact, EmployeeContact.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        EmployeeContact savedEmployeeContact = postResponse.getBody();
//
//        System.out.println("Saved data: " + savedEmployeeContact);
//        assertEquals(employeeContact.getEmployeeNumber(), savedEmployeeContact.getEmployeeNumber());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + employeeContact.getEmployeeNumber();
//        System.out.println("URL: " + url);
//        ResponseEntity<EmployeeContact> getResponse = restTemplate.getForEntity(url, EmployeeContact.class);
//        EmployeeContact readEmployeeContact = getResponse.getBody();
//        assertEquals(employeeContact.getEmployeeNumber(), readEmployeeContact.getEmployeeNumber());
//
//        System.out.println("Read: " + readEmployeeContact);
//
//
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//        EmployeeContact updateEmployeeContact = new EmployeeContact.Builder()
//                .copy(employeeContact)
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updateEmployeeContact);
//        ResponseEntity<EmployeeContact> response = restTemplate.postForEntity(url, updateEmployeeContact, EmployeeContact.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + employeeContact.getEmployeeNumber();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
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
//}