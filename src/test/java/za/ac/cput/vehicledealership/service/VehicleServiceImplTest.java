package za.ac.cput.vehicledealership.service;

/*  VehicleServiceImplTest.java
    Test class for VehicleServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.service.impl.VehicleServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleServiceImplTest {

    private static VehicleServiceImpl vehicleService = VehicleServiceImpl.getVehicleService();
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED,
            FuelType.PETROL, "White", 2019, 23000);


    @Order(1)
    @Test
    void create() {
        Vehicle createdVehicle = vehicleService.create(vehicle);
        assertNotNull(createdVehicle);
        System.out.println("Create: " + createdVehicle);
    }

    @Order(2)
    @Test
    void read() {
        Vehicle readVehicle = vehicleService.read(vehicle.getVehicleId());
        assertNotNull(readVehicle);
        System.out.println("Read: " + readVehicle);
    }

    @Order(3)
    @Test
    void update() {
        Vehicle updatedVehicle = new Vehicle.Builder()
            .copy(vehicle)
            .setYear(2021)
            .build();
        assertNotNull(vehicleService.update(updatedVehicle));
        System.out.println("Update: " + updatedVehicle);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = vehicleService.delete(vehicle.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(vehicleService.getAll());
        assertEquals(1, vehicleService.getAll().size());
    }
}