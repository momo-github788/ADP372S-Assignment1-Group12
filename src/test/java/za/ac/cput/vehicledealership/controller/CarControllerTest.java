///*  CarControllerTest.java
//    Test entity for Car controller
//    Author: Alan Chapman (220092362)
//    Date: 17 June 2023
//*/
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
//import za.ac.cput.vehicledealership.factory.CarFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class CarControllerTest {
//
//    private static Car car = CarFactory.createCar("Dodge", "Challenger SS", VehicleCondition.NEW,
//            FuelType.PETROL,"Black", 2000, 100, true, BodyType.SEDAN);
//    private final String BASE_URL = "http://localhost:8080/car";
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Test
//    @Order(1)
//    void create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<Car> responseEntity = restTemplate.postForEntity(url, car, Car.class);
//        assertNotNull(responseEntity);
//        assertNotNull(responseEntity.getBody());
//
//        Car savedCar = responseEntity.getBody();
//
//        System.out.println("Saved data: " + savedCar);
//        assertNotNull(car.getVehicleId(), savedCar.getVehicleId());
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//        String url = BASE_URL + "/read/" + car.getVehicleId();
//        System.out.println("URL " + url);
//        ResponseEntity<Car> getResponse = restTemplate.getForEntity(url, Car.class);
//        Car readCar = getResponse.getBody();
//        assertEquals(car.getVehicleId(), readCar.getVehicleId());
//
//        System.out.println("Read: " + readCar);
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        String url = BASE_URL + "/update";
//
//        Car updateCar = new Car.CarBuilder()
//                .copy(car)
//                .setMileage(80500)
//                .setCondition(VehicleCondition.USED)
//                .build();
//
//        System.out.println("URL: " + url);
//        System.out.println("POST data: " + updateCar);
//        ResponseEntity<Car> response = restTemplate.postForEntity(url, updateCar, Car.class);
//        assertNotNull(response.getBody());
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
//
//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + car.getVehicleId();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//    }
//}