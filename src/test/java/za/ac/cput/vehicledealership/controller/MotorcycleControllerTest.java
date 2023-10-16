/*  MotorcycleControllerTest.java
    Test entity for Motorcycle controller
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
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.MotorcycleFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MotorcycleControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Yamaha", "YZF R1M", VehicleCondition.NEW,
            FuelType.PETROL,"Blue & black", 2023, 0, true);
    private final String BASE_URL = "http://localhost:8080/motorcycle";
    private RestTemplate restTemplate = new RestTemplate();

    //Make variable static otherwise variable won't be carried across test cases
    private static int motorcycleId;

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

        HttpEntity<?> motorcycleEntity = performPostRequest(motorcycle);

        String url = BASE_URL + "/create?type=employee";

        ResponseEntity<Motorcycle> postResponse = restTemplate.postForEntity(url, motorcycleEntity, Motorcycle.class);
        Motorcycle savedMotorcycle = postResponse.getBody();

        System.out.println("Saved data: " + savedMotorcycle);
        assertNotNull(savedMotorcycle);

        motorcycleId = savedMotorcycle.getVehicleId();
        System.out.println("branch id " + motorcycleId);
    }

    @Test
    @Order(2)
    void read() throws Exception {

        String url = BASE_URL + "/read/" + motorcycleId + "?type=employee";
        System.out.println("URL " + url);

        ResponseEntity<Motorcycle> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForEmployee())
                .build(), Motorcycle.class);

        Motorcycle readMotorcycle = getResponse.getBody();
        assertEquals(motorcycleId, readMotorcycle.getVehicleId());

        System.out.println("Read: " + readMotorcycle);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Motorcycle updateMotorcycle = new Motorcycle.MotorcycleBuilder()
                .copy(motorcycle)
                .setMileage(2000)
                .setCondition(VehicleCondition.USED)
                .setHasSideCar(false)
                .build();

        updateMotorcycle.setVehicleId(motorcycleId);

        HttpEntity<?> motorcycleEntity = performPostRequest(updateMotorcycle);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + motorcycleEntity);
        ResponseEntity<Motorcycle> response = restTemplate.postForEntity(url, motorcycleEntity, Motorcycle.class);
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
    void delete() {

        authConfig.getAuthForEmployee();
        String url = BASE_URL + "/delete/" + motorcycleId + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> motorcycleEntity = performPostRequest(motorcycle);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, motorcycleEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }
}