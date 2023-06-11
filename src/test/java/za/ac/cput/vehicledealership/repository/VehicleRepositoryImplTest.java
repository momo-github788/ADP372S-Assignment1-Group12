package za.ac.cput.vehicledealership.repository;

/*  VehicleRepositoryImplTest.java
    Test class for VehicleRepositoryImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.repository.impl.VehicleRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleRepositoryImplTest {

    private static VehicleRepositoryImpl vehicleRepository = VehicleRepositoryImpl.getVehicleRepository();
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);


    @Order(1)
    @Test
    void create() {
        Vehicle createdVehicle = vehicleRepository.create(vehicle);
        assertNotNull(createdVehicle);
        System.out.println("Create: " + createdVehicle);
    }

    @Order(2)
    @Test
    void read() {
        Vehicle readVehicle = vehicleRepository.read(vehicle.getVehicleId());
        assertNotNull(readVehicle);
        System.out.println("Read: " + readVehicle);
    }

    @Order(3)
    @Test
    void update() {
        Vehicle updatedVehicle = new Vehicle.Builder<>()
                .copy(vehicle)
                .setMileage(59999)
                .build();
        assertNotNull(vehicleRepository.update(updatedVehicle));
        System.out.println("Update: " + updatedVehicle);


    }

    @Order(5)
    @Test
    void delete() {
        boolean success = vehicleRepository.delete(vehicle.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(vehicleRepository.getAll());
        assertEquals(1, vehicleRepository.getAll().size());
    }

}