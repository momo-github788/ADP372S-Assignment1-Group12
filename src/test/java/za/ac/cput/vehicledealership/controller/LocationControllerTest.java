package za.ac.cput.vehicledealership.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocationControllerTest {
    private static Location location = LocationFactory.createLocation(27, "Daisy", "Cape Town", "7850", "Western Cape");

    private final String BASE_URL = "http://localhost:8080/location";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Location> postResponse = restTemplate.postForEntity(url, location, Location.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Location savedLocation = postResponse.getBody();

        System.out.println("Saved data: " + savedLocation);
        assertEquals(location.getLocationId(), savedLocation.getLocationId());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + location.getLocationId();
        System.out.println("URL: " + url);
        ResponseEntity<Location> getResponse = restTemplate.getForEntity(url, Location.class);
        Location readLocation = getResponse.getBody();
        assertEquals(location.getLocationId(), readLocation.getLocationId());

        System.out.println("Read: " + readLocation);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Location updateLocation = new Location.Builder()
                .copy(location)
                .setStreetName("Rose")
                .build();

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateLocation);
        ResponseEntity<Location> response = restTemplate.postForEntity(url, updateLocation, Location.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + location.getLocationId();
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