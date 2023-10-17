package za.ac.cput.vehicledealership.controller;

/* ContactControllerTest.java
   Test class for Contact controller
   Author: Junaid Cedrass (219090912)
   Date: 17 June 2023
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.factory.ContactDetailFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactDetailControllerTest {

    @Autowired
    private UserRepository userRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static ContactDetail contact = ContactDetailFactory.createContact(ContactType.EMAIL, "ashwin2@gmail.com");
    private final String BASE_URL = "http://localhost:8080/contact";
    private RestTemplate restTemplate = new RestTemplate();

    private static int contactId;

    @BeforeEach
    void setUp() {
        if(!userRepository.existsByEmailAddress(TestAuthConfig.USER_NAME)) {
            authConfig.registerUser(new RegisterRequest(NameFactory.createName("Sarah", "", "Doe"), TestAuthConfig.USER_NAME, TestAuthConfig.PASSWORD));
        }
    }

    private HttpEntity<?> performPostRequest(Object object) {
        // This is an employee logged in
        return new HttpEntity<>(object, authConfig.getAuthForUser());
    }

    @Test
    @Order(1)
    void create() {
        HttpEntity<?> contactEntity = performPostRequest(contact);
        String url = BASE_URL + "/create?type=user";
        ResponseEntity<ContactDetail> postResponse = restTemplate.postForEntity(url, contactEntity, ContactDetail.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        ContactDetail savedContact = postResponse.getBody();

        System.out.println("Saved data: " + savedContact);
        assertNotNull(savedContact);
        contactId = savedContact.getContactDetailId();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + contactId + "?type=user";
        System.out.println("URL: " + url);

        ResponseEntity<ContactDetail> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                        .headers(authConfig.getAuthForUser())
                        .build(), ContactDetail.class);

        ContactDetail readContact = getResponse.getBody();
        assertEquals(contactId, readContact.getContactDetailId());

        System.out.println("Read: " + readContact);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=user";

        ContactDetail updateContact = new ContactDetail.ContactBuilder()
                .copy(contact)
                .setValue("ashwin3@gmail.com")
                .build();

        updateContact.setContactDetailId(contactId);

        HttpEntity<?> contactEntity = performPostRequest(updateContact);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateContact);
        ResponseEntity<ContactDetail> response = restTemplate.postForEntity(url, contactEntity, ContactDetail.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        authConfig.getAuthForUser();

        String url = BASE_URL + "/delete/" + contactId + "?type=user";
        HttpEntity<?> contactEntity = performPostRequest(contact);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, contactEntity, String.class);
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