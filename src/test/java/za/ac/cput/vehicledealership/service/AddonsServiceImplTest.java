package za.ac.cput.vehicledealership.service;
/*  AddonsSerciveImplTest.java
    Test class for AddonsServiceImpl
    Author: George Tapiwa Charimba (220073465)
    Date: 11 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.AddonsFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.service.impl.AddonsServiceImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddonsServiceImplTest {

    private static AddonsServiceImpl addonsService = AddonsServiceImpl.getAddonsServiceService();
    private static Addons addons = AddonsFactory.createAddons("Audi", "A4", LocalDateTime.now(), AddonType.DETAILINGADDON, 15000, 12, 12);


    @Order(1)
    @Test
    void create() {
        Addons createdAddons = addonsService.create(addons);
        assertNotNull(createdAddons);
        System.out.println("Create: " + createdAddons);
    }

    @Order(2)
    @Test
    void read() {
        Addons readAddons = addonsService.read(addons.getAddonId());
        assertNotNull(readAddons);
        System.out.println("Read: " + readAddons);
    }

    @Order(3)
    @Test
    void update() {
        Addons updatedAddons = new Addons.Builder()
                .copy(addons)
                .build();
        assertNotNull(addonsService.update(updatedAddons));
        System.out.println("Update: " + updatedAddons);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = addonsService.delete(addons.getAddonId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(addonsService.getAll());
        assertEquals(1, addonsService.getAll().size());
    }
}