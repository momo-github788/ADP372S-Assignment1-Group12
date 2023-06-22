package za.ac.cput.vehicledealership.repository;
/*  EmployeeContactRepositoryImplTest.java
    Test class for EmployeeContact Repository
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.factory.EmployeeContactFactory;
import za.ac.cput.vehicledealership.repository.impl.EmployeeContactRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeContactRepositoryImplTest {

    private static EmployeeContactRepositoryImpl employeeContactRepository = EmployeeContactRepositoryImpl.getEmployeeContactRepository();
    private static Contact contact = ContactFactory.createContact("0629390280", "geocharimba@gmail.com");
    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(contact);


    @Order(1)
    @Test
    void create() {
        EmployeeContact createdEmployeeContact = employeeContactRepository.create(employeeContact);
        assertNotNull(createdEmployeeContact);
        System.out.println("Create: " + createdEmployeeContact);
    }

    @Order(2)
    @Test
    void read() {
        EmployeeContact readEmployeeContact = employeeContactRepository.read(employeeContact.getEmployeeNumber());
        assertNotNull(readEmployeeContact);
        System.out.println("Read: " + readEmployeeContact);
    }

    @Order(3)
    @Test
    void update() {
        EmployeeContact updatedEmployeeContact = new EmployeeContact.Builder()
                .copy(employeeContact)
                .build();
        assertNotNull(employeeContactRepository.update(updatedEmployeeContact));
        System.out.println("Update: " + updatedEmployeeContact);


    }

    @Order(5)
    @Test
    void delete() {
        boolean success = employeeContactRepository.delete(employeeContact.getEmployeeNumber());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(employeeContactRepository.getAll());
        assertEquals(1, employeeContactRepository.getAll().size());
    }
}