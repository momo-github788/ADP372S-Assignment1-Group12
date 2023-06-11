/*  MotorcycleServiceImplTest.java
    Test class for MotorcycleServiceImpl
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.MotorcycleFactory;
import za.ac.cput.vehicledealership.service.impl.MotorcycleServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MotorcycleServiceImplTest {
    private static MotorcycleServiceImpl motorcycleService = MotorcycleServiceImpl.getMotorcycleService();
    private static Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", "Vittorio Brumotti - Sportster S", VehicleCondition.NEW,
            FuelType.PETROL,"Navy blue", 2022, 0, false);
    @Order(1)
    @Test
    void create() {
        Motorcycle createdMotorcycle= motorcycleService.create(motorcycle);
        assertNotNull(createdMotorcycle);
        System.out.println("Create: " + createdMotorcycle);
    }

    @Order(2)
    @Test
    void read() {
        Motorcycle readMotorcycle = motorcycleService.read(motorcycle.getVehicleId());
        assertNotNull(readMotorcycle);
        System.out.println("Read: " + readMotorcycle);
    }

    @Order(3)
    @Test
    void update() {
        Motorcycle updatedMotorcycle = new Motorcycle.MotorcycleBuilder()
                .copy(motorcycle)
                .setColour("Black")
                .setHasSideCar(true)
                .build();

        assertNotNull(motorcycleService.update(updatedMotorcycle));
        System.out.println("Update: " + updatedMotorcycle);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = motorcycleService.delete(motorcycle.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(motorcycleService.getAll());
        assertEquals(1, motorcycleService.getAll().size());
    }
}