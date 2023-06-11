package za.ac.cput.vehicledealership.repository.impl;
/*  AddonsRepositoryImplTest.java
    Test class for AddonsFactoryRepositoryImpl
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.AddonType;
import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.factory.AddonsFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddonsRepositoryImplTest {

    private static AddonsRepositoryImpl addonsRepository = AddonsRepositoryImpl.getAddonsRepository();
    private static AddonType addonsType = AddonType.SERVICINGADDON;
    private static Addons addons = AddonsFactory.createAddons("Service", "Mini service", LocalDateTime.now(), AddonType.SERVICINGADDON, 10000, 12, 6);


    @Order(1)
    @Test
    void create() {
        Addons createdAddons = addonsRepository.create(addons);
        assertNotNull(createdAddons);
        System.out.println("Create: " + createdAddons);
    }

    @Order(2)
    @Test
    void read() {
        Addons readAddons = addonsRepository.read(addons.getAddonId());
        assertNotNull(readAddons);
        System.out.println("Read: " + readAddons);
    }

    @Order(3)
    @Test
    void update() {
        Addons updatedAddons = new Addons.Builder()
                .copy(addons)
                .build();
        assertNotNull(addonsRepository.update(updatedAddons));
        System.out.println("Update: " + updatedAddons);


    }

    @Order(5)
    @Test
    void delete() {
        boolean success = addonsRepository.delete(addons.getAddonId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(addonsRepository.getAll());
        assertEquals(1, addonsRepository.getAll().size());
    }
}