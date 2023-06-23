package za.ac.cput.vehicledealership.service;

/*  LocationServiceImplTest.java
    Test class for LocationServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.factory.LocationFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LocationServiceImplTest {

    @Autowired
    private LocationService locationService;
    private static Location location = LocationFactory.createLocation(27, "Daisy", "Cape Town", "7850", "Western Cape");


    @Order(1)
    @Test
    void create() {
        Location createdLocation = locationService.create(location);
        assertNotNull(createdLocation);
        System.out.println("Create: " + createdLocation);
    }

    @Order(2)
    @Test
    void read() {
        Location readLocation = locationService.read(location.getLocationId());
        assertNotNull(readLocation);
        System.out.println("Read: " + readLocation);
    }

    @Order(3)
    @Test
    void update() {
        Location updatedLocation = new Location.Builder().copy(location)
                .setStreetNumber(129)
                .setPostalCode("8982")
                .build();
        assertNotNull(locationService.update(updatedLocation));
        System.out.println("Update: " + updatedLocation);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = locationService.delete(location.getLocationId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(locationService.getAll());
        assertEquals(1, locationService.getAll().size());
    }
}