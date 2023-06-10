/*  MotorcycleRepositoryImplTest.java
    Test class for MotorcycleRepositoryImpl
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/

package za.ac.cput.vehicledealership.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.MotorcycleFactory;
import za.ac.cput.vehicledealership.repository.impl.MotorcycleRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MotorcycleRepositoryImplTest {
    private static MotorcycleRepositoryImpl motorcycleRepository = MotorcycleRepositoryImpl.getRepository();
    public static Motorcycle motorcycle = MotorcycleFactory.createMotorcycle("Harley-Davidson", "Vittorio Brumotti - Sportster S", VehicleCondition.NEW,
            FuelType.PETROL,"Navy blue", 2022, 0, false);

    @Order(1)
    @Test
    void create() {
        Motorcycle createdMotorcycle = motorcycleRepository.create(motorcycle);
        assertNotNull(createdMotorcycle);
        System.out.println("Create: " + createdMotorcycle);
    }

    @Order(2)
    @Test
    void read() {
        Motorcycle readMotorcycle = motorcycleRepository.read(motorcycle.getVehicleId());
        assertNotNull(readMotorcycle);
        System.out.println("Read: " + readMotorcycle);
    }

    @Order(3)
    @Test
    void update() {
        Motorcycle updatedMotorcycle = new Motorcycle.MotorcycleBuilder()
                .copy(motorcycle)
                .setModel("Vittorio Brumotti")
                .setHasSideCar(true)
                .build();
        assertNotNull(motorcycleRepository.update(updatedMotorcycle));
        System.out.println("Update: " + updatedMotorcycle);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = motorcycleRepository.delete(motorcycle.getVehicleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(motorcycleRepository.getAll());
        assertEquals(1,motorcycleRepository.getAll().size());
    }
}