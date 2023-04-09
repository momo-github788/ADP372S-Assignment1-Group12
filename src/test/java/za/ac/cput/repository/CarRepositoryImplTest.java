/*  CarRepositoryImplTest.java
    Test class for CarRepositoryImpl
    Author: Alan Chapman (220092362)
    Date: 7 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Car;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.VehicleCondition;
import za.ac.cput.factory.CarFactory;
import za.ac.cput.repository.CarRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarRepositoryImplTest {
    private static CarRepositoryImpl carRepository = CarRepositoryImpl.getRepository();
    public static Car car = CarFactory.createCar("Ford", "Fiesta", VehicleCondition.DEMO,
            FuelType.ELECTRIC,"White", 2021, 150, true);

    @Order(1)
    @Test
    void create() {
        Car createdCar = carRepository.create(car);
        assertNotNull(createdCar);
        System.out.println("Create: " + createdCar);
    }

    @Order(2)
    @Test
    void read() {
        Car readCar = carRepository.read(car.getVehicleId());
        assertNotNull(readCar);
        System.out.println("Read: " + readCar);
    }

    @Order(3)
    @Test
    void update() {
        Car updatedCar = new Car.CarBuilder()
                .copy(car)
                .setYear(2009)
                .build();
        assertNotNull(carRepository.update(updatedCar));
        System.out.println("Update: " + updatedCar);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = carRepository.delete(car.getVehicleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(carRepository.getAll());
        assertEquals(1, carRepository.getAll().size());
    }
}