/*  CarControllerTest.java
    Test entity for Car controller
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
import za.ac.cput.vehicledealership.factory.CarFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();

    private static Car car = CarFactory.createCar("Dodge", "Challenger SS", VehicleCondition.NEW,
            FuelType.PETROL,"Black", 2000, 100, true, BodyType.SEDAN);
    private final String BASE_URL = "http://localhost:8080/car";
    private RestTemplate restTemplate = new RestTemplate();

    //Make variable static otherwise variable won't be carried across test cases
    private static int carId;

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

        HttpEntity<?> carEntity = performPostRequest(car);

        String url = BASE_URL + "/create?type=employee";

        ResponseEntity<Car> postResponse = restTemplate.postForEntity(url, carEntity, Car.class);
        Car savedCar = postResponse.getBody();

        System.out.println("Saved data: " + savedCar);
        assertNotNull(savedCar);

        carId = savedCar.getVehicleId();
        System.out.println("car id " + carId);
    }


    @Test
    @Order(2)
    void read() throws Exception {

        String url = BASE_URL + "/read/" + carId + "?type=employee";
        System.out.println("URL " + url);

        ResponseEntity<Car> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                .headers(authConfig.getAuthForEmployee())
                .build(), Car.class);

        Car readCar = getResponse.getBody();
        assertEquals(carId, readCar.getVehicleId());

        System.out.println("Read: " + readCar);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Car updateCar = new Car.CarBuilder()
                .copy(car)
                .setMileage(80500)
                .setCondition(VehicleCondition.USED)
                .build();

        updateCar.setVehicleId(carId);

        HttpEntity<?> carEntity = performPostRequest(updateCar);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + carEntity);
        ResponseEntity<Car> response = restTemplate.postForEntity(url, carEntity, Car.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() throws URISyntaxException {

        authConfig.getAuthForEmployee();
        String url = BASE_URL + "/delete/" + carId + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> carEntity = performPostRequest(car);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, carEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
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
}