package za.ac.cput.vehicledealership.service;

/*  NameServiceImplTest.java
    Test class for NameServiceImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.service.impl.NameServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameServiceImplTest {

    private static Name name = NameFactory.createNameFactory("Mary", "", "Anne");
    private static NameServiceImpl nameService = NameServiceImpl.getNameService();

    @Order(1)
    @Test
    void create() {
        Name createdName = nameService.create(name);
        assertNotNull(createdName);
        System.out.println("Create: " + createdName);
    }

    @Order(2)
    @Test
    void read() {
        Name readName = nameService.read(name.getFirstName());
        assertNotNull(readName);
        System.out.println("Read: " + readName);
    }

    @Order(3)
    @Test
    void update() {
        Name updatedName = new Name.Builder().copy(name)
                .setMiddleName("Julia")
                .build();
        assertNotNull(nameService.update(updatedName));
        System.out.println("Update: " + updatedName);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = nameService.delete(name.getFirstName());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(nameService.getAll());
        assertEquals(1, nameService.getAll().size());
    }
}