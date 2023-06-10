package za.ac.cput.vehicledealership.repository;
/*  PVehicleAddonsRepositoryImplTest.java
    Test class for VehicleAddonsRepositoryImpl
    Author:Kimpoki Serge Kalala (220525137)
    Date: 07/04/2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.factory.VehicleAddonsFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleAddonsRepositoryImplTest {


    private static VehicleAddonsRepositoryImpl Repository =VehicleAddonsRepositoryImpl.getRepository();


    private static VehicleAddons  vehicleAddons= VehicleAddonsFactory.createVehicleAddonsFactory(
            "1238906","23456");

    @Order(1)
    @Test
    void create() {
        VehicleAddons created= Repository.create(vehicleAddons);
        assertNotNull(created);
        System.out.println("Create: " + created);
    }

    @Order(2)
    @Test
    void b_read() {
        VehicleAddons readvehicle =Repository.read(vehicleAddons.getVehicleId());

        System.out.println("Read: " + readvehicle);
    }
    @Order(3)
    @Test
    void c_update() {
        VehicleAddons updated= new VehicleAddons.Builder()
                .copy(vehicleAddons)
                .setVehicleId("12344")
                .build();
        assertNotNull(Repository.update(updated));
        System.out.println("Update: " + updated);
    }
    @Order(4)
    @Test
    void d_delete() {
        boolean success = Repository.delete(vehicleAddons.getVehicleId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }
    @Order(5)
    @Test
    void e_getAll() {
        System.out.println("Get all: "+ Repository.getAll());
//        System.out.println(Repository.getAll());
//        assertEquals(0, Repository.getAll().size());
    }
}