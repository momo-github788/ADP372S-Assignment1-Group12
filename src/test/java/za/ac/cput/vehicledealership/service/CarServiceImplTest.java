/*  CarServiceImplTest.java
    Test class for CarServiceImpl
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.CarFactory;
import za.ac.cput.vehicledealership.service.impl.CarServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class CarServiceImplTest {

    @Autowired
    private CarServiceImpl carService;
    private static Car car = CarFactory.createCar("Ford", "Fiesta", VehicleCondition.DEMO,
            FuelType.ELECTRIC,"White", 2021, 150, true, BodyType.HATCHBACK);

    @Order(1)
    @Test
    void create() {
        Car createdCar= carService.create(car);
        assertNotNull(createdCar);
        System.out.println("Create: " + createdCar);
    }

    @Order(2)
    @Test
    void read() {
        Car readCar = carService.read(car.getVehicleId());
        assertNotNull(readCar);
        System.out.println("Read: " + readCar);
    }

    @Order(3)
    @Test
    void update() {
        Car updatedCar = new Car.CarBuilder()
                .copy(car)
                .setMake("Tesla")
                .setModel("Model O")
                .setYear(2022)
                .setBodyType(BodyType.SEDAN)
                .build();

        assertNotNull(carService.update(updatedCar));
        System.out.println("Update: " + updatedCar);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = carService.delete(car.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(carService.getAll());
    }
}