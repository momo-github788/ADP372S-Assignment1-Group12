package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.TruckFactory;
import za.ac.cput.vehicledealership.service.impl.TruckServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TruckServiceImplTest {
    private static TruckServiceImpl truckService = TruckServiceImpl.getTruckService();
    private static Truck truck = TruckFactory.createTruck("Mercedes Benz", "Actros", VehicleCondition.USED, FuelType.DIESEL,"red",
            2023, 1006, 6, 13607.8);

    @Order(1)
    @Test
    void create() {
        Truck createdTruck= truckService.create(truck);
        assertNotNull(createdTruck);
        System.out.println("Create: " + createdTruck);
    }

    @Order(2)
    @Test
    void read() {
        Truck readTruck = truckService.read(truck.getVehicleId());
        assertNotNull(readTruck);
        System.out.println("Read: " + readTruck);
    }

    @Order(3)
    @Test
    void update() {
        Truck updatedTruck = new Truck.TruckBuilder()
                .copy(truck)
                .setCondition(VehicleCondition.NEW)
                .setColour("White")
                .build();

        assertNotNull(truckService.update(updatedTruck));
        System.out.println("Update: " + updatedTruck);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = truckService.delete(truck.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(truckService.getAll());
        assertEquals(1, truckService.getAll().size());
    }
}