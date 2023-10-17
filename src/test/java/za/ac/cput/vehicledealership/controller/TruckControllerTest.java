/*  TruckControllerTest.java
    Test entity for Truck controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.factory.TruckFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TruckControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();
    private static Truck truck = TruckFactory.createTruck("Mercedes Benz", "Actros", VehicleCondition.USED, FuelType.DIESEL,"blue",
            2023, 1006, 6, 13607.8);
    private final String BASE_URL = "http://localhost:8080/truck";
    private RestTemplate restTemplate = new RestTemplate();

    //Make variable static otherwise variable won't be carried across test cases
    private static int truckId;

    @BeforeEach
    void setUp() {
        if(!userRepository.existsByEmailAddress(TestAuthConfig.USER_NAME)) {
            authConfig.registerUser(new RegisterRequest(NameFactory.createName("Sarah", "", "Doe"), TestAuthConfig.USER_NAME, TestAuthConfig.PASSWORD));
        }
        if(!employeeRepository.existsByEmailAddress(TestAuthConfig.EMPLOYEE_NAME)) {
            authConfig.registerEmployee(new RegisterRequest(NameFactory.createName("John", "", "Doe"), TestAuthConfig.EMPLOYEE_NAME, TestAuthConfig.PASSWORD));

        }
    }

    // Use for POST requests where employees can access endpoints (ADMIN ROLE)
    private HttpEntity<?> performPostRequest(Object object) {
        // This is an employee logged in
        return new HttpEntity<>(object, authConfig.getAuthForEmployee());
    }

    @Test
    @Order(1)
    void create() {

        HttpEntity<?> truckEntity = performPostRequest(truck);

        String url = BASE_URL + "/create?type=employee";

        ResponseEntity<Truck> postResponse = restTemplate.postForEntity(url, truckEntity, Truck.class);
        Truck savedTruck = postResponse.getBody();

        System.out.println("Saved data: " + savedTruck);
        assertNotNull(savedTruck);

        truckId = savedTruck.getVehicleId();
        System.out.println("truck id " + truckId);
    }

    @Test
    @Order(2)
    void read() throws Exception{
        String url = BASE_URL + "/read/" + truckId + "?type=employee";
        System.out.println("URL " + url);

        ResponseEntity<Truck> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForEmployee())
                .build(), Truck.class);

        Truck readTruck = getResponse.getBody();
        assertEquals(truckId, readTruck.getVehicleId());

        System.out.println("Read: " + readTruck);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Truck updateTruck = new Truck.TruckBuilder()
                .copy(truck)
                .setMileage(0)
                .setCondition(VehicleCondition.NEW)
                .setFuelType(FuelType.PETROL)
                .build();

        updateTruck.setVehicleId(truckId);

        HttpEntity<?> truckEntity = performPostRequest(updateTruck);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateTruck);
        ResponseEntity<Truck> response = restTemplate.postForEntity(url, truckEntity, Truck.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll?type=employee";
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(authConfig.getAuthForEmployee());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(5)
    void delete() throws URISyntaxException {
        String url = BASE_URL + "/delete/" + truckId + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> truckEntity = performPostRequest(truck);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, truckEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }
}