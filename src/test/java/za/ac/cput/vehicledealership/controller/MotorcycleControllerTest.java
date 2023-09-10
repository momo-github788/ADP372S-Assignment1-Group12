/*  MotorcycleControllerTest.java
    Test entity for Motorcycle controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.MotorcycleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MotorcycleControllerTest {

    private static Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Yamaha", "YZF R1M", VehicleCondition.NEW,
            FuelType.PETROL,"Blue & black", 2023, 0, true);
    private final String BASE_URL = "http://localhost:8080/motorcycle";
    private RestTemplate restTemplate = new RestTemplate();

    //Make variable static otherwise variable won't be carried across test cases
    private static int motorcycleId;


    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Motorcycle> responseEntity = restTemplate.postForEntity(url, motorcycle, Motorcycle.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());

        Motorcycle savedMotorcycle = responseEntity.getBody();

        System.out.println("Saved data: " + savedMotorcycle);
        assertNotNull(1, String.valueOf(savedMotorcycle.getVehicleId()));

        motorcycleId = savedMotorcycle.getVehicleId();
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + motorcycleId;
        System.out.println("URL " + url);
        ResponseEntity<Motorcycle> getResponse = restTemplate.getForEntity(url, Motorcycle.class);
        Motorcycle readMotorcycle = getResponse.getBody();
        assertEquals(motorcycleId, readMotorcycle.getVehicleId());

        System.out.println("Read: " + readMotorcycle);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Motorcycle updateMotorcycle = new Motorcycle.MotorcycleBuilder()
                .copy(motorcycle)
                .setMileage(2000)
                .setCondition(VehicleCondition.USED)
                .setHasSideCar(false)
                .build();

        updateMotorcycle.setVehicleId(motorcycleId);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateMotorcycle);
        ResponseEntity<Motorcycle> response = restTemplate.postForEntity(url, updateMotorcycle, Motorcycle.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + motorcycleId;
        System.out.println("URL: " + url);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }
}