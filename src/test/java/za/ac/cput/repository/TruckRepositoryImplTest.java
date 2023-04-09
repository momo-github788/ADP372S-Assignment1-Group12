/*  TruckRepositoryImplTest.java
    Test class for VehicleRepositoryImpl
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/
package za.ac.cput.repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Truck;
import za.ac.cput.domain.VehicleCondition;
import za.ac.cput.factory.TruckFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TruckRepositoryImplTest {
    public static TruckRepositoryImpl truckRepository = TruckRepositoryImpl.getRepository();
     public static Truck truck = TruckFactory.createTruck("Mercedes Benz", "Actros", VehicleCondition.USED, FuelType.DIESEL,"red",
            2022, 1200, 6, 13607.8);

    @Order(1)
    @Test
    void create() {
        Truck createdTruck = truckRepository.create(truck);
        assertNotNull(createdTruck);
        System.out.println("Create: " + createdTruck);
    }

    @Order(2)
    @Test
    void read() {
        Truck readTruck = truckRepository.read(truck.getVehicleId());
        assertNotNull(readTruck);
        System.out.println("Read: " + readTruck);
    }

    @Order(3)
    @Test
    void update() {
        Truck updatedCar = new Truck.TruckBuilder()
                .copy(truck)
                .setCondition(VehicleCondition.NEW)
                .setMileage(160)
                .setYear(2023)
                .setMaxLoadCapacity(13800)
                .build();
        assertNotNull(truckRepository.update(updatedCar));
        System.out.println("Update: " + updatedCar);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = truckRepository.delete(truck.getVehicleId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Show all: ");
        System.out.println(truckRepository.getAll());
        assertEquals(1, truckRepository.getAll().size());
    }
}