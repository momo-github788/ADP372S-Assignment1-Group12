//package za.ac.cput.vehicledealership.controller;
//
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.factory.BranchFactory;
//import za.ac.cput.vehicledealership.factory.EmployeeFactory;
//import za.ac.cput.vehicledealership.factory.LocationFactory;
//import za.ac.cput.vehicledealership.factory.NameFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Disabled
//class BranchControllerTest {
//
//    private static City city;
//    private static Location location = LocationFactory.createLocation(89974, "Main Road", city , "7626", "Western Cape");
//
//    private static Branch branch = BranchFactory.createBranch("Paarl Auto", 2008, location);
//
//    private final String BASE_URL = "http://localhost:8080/employee";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    @Order(1)
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Branch> postResponse = restTemplate.postForEntity(url, branch, Branch.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        Branch savedBranch = postResponse.getBody();
//
//        System.out.println("Saved data: " + savedBranch);
//        assertEquals(branch.getBranchId(), savedBranch.getBranchId());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + branch.getBranchId();
//        System.out.println("URL: " + url);
//        ResponseEntity<Branch> getResponse = restTemplate.getForEntity(url, Branch.class);
//        Branch readBranch = getResponse.getBody();
//        assertEquals(branch.getBranchId(), readBranch.getBranchId());
//
//        System.out.println("Read: " + readBranch);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//        Location location = LocationFactory.createLocation(46664, "Marvel",city, "8200", "Western cape");
//        Branch updateBranch = new Branch.BranchBuilder()
//                .copy(branch)
//                .setLocation(location)
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updateBranch);
//        ResponseEntity<Branch> response = restTemplate.postForEntity(url, updateBranch, Branch.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + branch.getBranchId();
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
//
