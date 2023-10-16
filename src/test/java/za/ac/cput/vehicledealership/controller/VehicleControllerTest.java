package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VehicleControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);

    private final String BASE_URL = "http://localhost:8080/vehicle";
    private RestTemplate restTemplate = new RestTemplate();

    private static int vehicleId;

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

        HttpEntity<?> vehicleEntity = performPostRequest(vehicle);

        String url = BASE_URL + "/create?type=employee";

        ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(url, vehicleEntity, Vehicle.class);
        Vehicle savedVehicle = postResponse.getBody();

        System.out.println("Saved data: " + savedVehicle);
        assertNotNull(savedVehicle);

        vehicleId = savedVehicle.getVehicleId();
        System.out.println("vehicle id " + vehicleId);
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + vehicleId + "?type=employee";
        System.out.println("URL: " + url);

        ResponseEntity<Vehicle> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForEmployee())
                        .build(), Vehicle.class);

        Vehicle readVehicle = getResponse.getBody();
        assertEquals(vehicleId, readVehicle.getVehicleId());

        System.out.println("Read: " + readVehicle);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Vehicle updateVehicle = new Vehicle.Builder()
                .copy(vehicle)
                .setMileage(27544)
                .build();


        updateVehicle.setVehicleId(vehicleId);

        HttpEntity<?> vehicleEntity = performPostRequest(updateVehicle);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + vehicleEntity);
        ResponseEntity<Vehicle> response = restTemplate.postForEntity(url, vehicleEntity, Vehicle.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {

        authConfig.getAuthForEmployee();
        String url = BASE_URL + "/delete/" + vehicleId + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> vehicleEntity = performPostRequest(vehicle);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, vehicleEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/all?type=employee";
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(authConfig.getAuthForEmployee());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}