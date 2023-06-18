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
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.AddonsFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddonsControllerTest {

    private static Addons addons = AddonsFactory.createAddons("Sunroof", "Panoramic", LocalDateTime.now(), AddonType.DETAILINGADDON, 1500, 12, 5000);

    private final String BASE_URL = "http://localhost:8080/addons";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Addons> postResponse = restTemplate.postForEntity(url, addons, Addons.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Addons savedAddons = postResponse.getBody();

        System.out.println("Saved data: " + savedAddons);
        assertEquals(addons.getAddonId(), savedAddons.getAddonId());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + addons.getAddonId();
        System.out.println("URL: " + url);
        ResponseEntity<Addons> getResponse = restTemplate.getForEntity(url, Addons.class);
        Addons readAddons = getResponse.getBody();
        assertEquals(addons.getAddonId(), readAddons.getAddonId());

        System.out.println("Read: " + readAddons);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";

        Addons updateAddons = new Addons.Builder()
                .copy(addons)
                .setName("Towbar")
                .build();

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateAddons);
        ResponseEntity<Addons> response = restTemplate.postForEntity(url, updateAddons, Addons.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        String url = BASE_URL + "/delete/" + addons.getAddonId();
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