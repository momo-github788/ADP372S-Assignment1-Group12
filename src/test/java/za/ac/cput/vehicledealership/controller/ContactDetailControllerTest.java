package za.ac.cput.vehicledealership.controller;

/* ContactControllerTest.java
   Test class for Contact controller
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.factory.ContactDetailFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactDetailControllerTest {

    private static ContactDetail contact = ContactDetailFactory.createContact(ContactType.EMAIL, "ashwin2@gmail.com");
    private final String BASE_URL = "http://localhost:8080/contact";
    private RestTemplate restTemplate = new RestTemplate();
    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<ContactDetail> postResponse = restTemplate.postForEntity(url, contact, ContactDetail.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        ContactDetail savedContact = postResponse.getBody();

        System.out.println("Saved data: " + savedContact);
        assertNotNull(savedContact);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + 1;
        System.out.println("URL: " + url);
        ResponseEntity<ContactDetail> getResponse = restTemplate.getForEntity(url, ContactDetail.class);
        ContactDetail readContact = getResponse.getBody();
        assertEquals(1, readContact.getContactDetailId());

        System.out.println("Read: " + readContact);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        ContactDetail updateContact = new ContactDetail.ContactBuilder()
                .copy(contact)
                .setValue("ashwin3@gmail.com")
                .build();

        updateContact.setContactDetailId(1);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateContact);
        ResponseEntity<ContactDetail> response = restTemplate.postForEntity(url, updateContact, ContactDetail.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + 1;
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