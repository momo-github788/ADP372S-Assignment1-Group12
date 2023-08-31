/*  TruckControllerTest.java
    Test entity for Truck controller
    Author: Alan Chapman (220092362)
    Date: 17 June 2023
*/
package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.TruckFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TruckControllerTest {
    private static Truck truck = TruckFactory.createTruck("Mercedes Benz", "Actros", VehicleCondition.USED, FuelType.DIESEL,"blue",
            2023, 1006, 6, 13607.8);
    private final String BASE_URL = "http://localhost:8080/truck";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Truck> responseEntity = restTemplate.postForEntity(url, truck, Truck.class);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());

        Truck savedTruck = responseEntity.getBody();

        System.out.println("Saved data: " + savedTruck);
        assertNotNull(truck.getVehicleId(), savedTruck.getVehicleId());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + truck.getVehicleId();
        System.out.println("URL " + url);
        ResponseEntity<Truck> getResponse = restTemplate.getForEntity(url, Truck.class);
        Truck readTruck = getResponse.getBody();
        assertEquals(truck.getVehicleId(), readTruck.getVehicleId());

        System.out.println("Read: " + readTruck);
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Truck updateTruck = new Truck.TruckBuilder()
                .copy(truck)
                .setMileage(0)
                .setCondition(VehicleCondition.NEW)
                .setFuelType(FuelType.PETROL)
                .build();

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateTruck);
        ResponseEntity<Truck> response = restTemplate.postForEntity(url, updateTruck, Truck.class);
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
        String url = BASE_URL + "/delete/" + truck.getVehicleId();
        System.out.println("URL: " + url);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion
    }
}