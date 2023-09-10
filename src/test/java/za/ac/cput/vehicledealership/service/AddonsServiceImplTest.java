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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.Addon;
import za.ac.cput.vehicledealership.domain.AddonType;
import za.ac.cput.vehicledealership.factory.AddonsFactory;
import za.ac.cput.vehicledealership.service.impl.AddonsServiceImpl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddonsServiceImplTest {

    @Autowired
    private AddonsServiceImpl addonsService;

    private static Addon addon = AddonsFactory.createAddons("Sunroof", "Panoramic", LocalDateTime.now(), AddonType.DETAILING,
            1500, 12, 5000);

    @Order(1)
    @Test
    void create() {
        Addon createdAddon = addonsService.create(addon);
        assertNotNull(addon);
        System.out.println("Create: " + createdAddon);
    }

    @Order(2)
    @Test
    void read() {
        Addon readAddon = addonsService.read(addon.getAddonId());
        assertNotNull(readAddon);
        System.out.println("Read: " + readAddon);
    }

    @Order(3)
    @Test
    void update() {
        Addon updatedAddon = new Addon.Builder()
                .copy(addon)
                .setMaximumMileageLimit (15000)
                .build();
        assertNotNull(addonsService.update(updatedAddon));
        System.out.println("Update: " + updatedAddon);

    }

    @Order(5)
    @Test
    void delete() {
        boolean success = addonsService.delete(addon.getAddonId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(addonsService.getAll());
    }
}