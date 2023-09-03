package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BranchControllerTest {

    private static Location location = LocationFactory.createLocation(89974, "Main Road", "Paarl", 7626, "Western Cape");
    private static Branch branch  = BranchFactory.createBranch("Paarl",2008,location);


    private final String BASE_URL = "http://localhost:8080/branch";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Branch> postResponse = restTemplate.postForEntity(url, branch, Branch.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Branch savedBranch = postResponse.getBody();

        System.out.println("Saved data: " + savedBranch);
        assertNotNull(savedBranch);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + 1;
        System.out.println("URL: " + url);
        ResponseEntity<Branch> getResponse = restTemplate.getForEntity(url, Branch.class);
        Branch readBranch = getResponse.getBody();
        assertEquals(1, readBranch.getBranchId());

        System.out.println("Read: " + readBranch);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Location location = LocationFactory.createLocation(46664, "Marvel", "Durban", 8200, "Western cape");
        Branch updateBranch = new Branch.BranchBuilder()
                .copy(branch)
                .setLocation(location)
                .build();

        updateBranch.setBranchId(1);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateBranch);
        ResponseEntity<Branch> response = restTemplate.postForEntity(url, updateBranch, Branch.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + 1;
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

