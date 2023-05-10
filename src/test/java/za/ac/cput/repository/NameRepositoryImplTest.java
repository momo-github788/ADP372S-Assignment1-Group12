package za.ac.cput.repository;

/*  NameRepositoryImplTest.java
    Test class for NameRepositoryImpl
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Name;
import za.ac.cput.factory.NameFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NameRepositoryImplTest {

    private static NameRepositoryImpl nameRepository = NameRepositoryImpl.getNameRepository();
    private static Name name = NameFactory.createNameFactory("John", "James", "Doe");

    @Order(1)
    @Test
    void create() {
        Name createdName = nameRepository.create(name);
        assertNotNull(createdName);
        System.out.println("Create: " + createdName);
    }

    @Order(2)
    @Test
    void read() {
        Name readName = nameRepository.read(name.getFirstName());
        assertNotNull(readName);
        System.out.println("Read: " + readName);
    }

    @Order(3)
    @Test
    void update() {
        Name updatedName = new Name.Builder().copy(name)
                .setLastName("Gabriel")
                .build();
        assertNotNull(nameRepository.update(updatedName));
        System.out.println("Update: " + updatedName);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = nameRepository.delete(name.getFirstName());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(nameRepository.getAll());
        assertEquals(1, nameRepository.getAll().size());
    }
}