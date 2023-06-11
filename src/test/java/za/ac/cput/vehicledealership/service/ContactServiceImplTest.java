package za.ac.cput.vehicledealership.service;
/*  ContactServiceImplTest.java
    Test class for ContactServiceImpl
    Author: Junaid Cedrass (219090912)
    Date: 10 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.service.impl.ContactServiceImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceImplTest {

    private static Contact contact = ContactFactory.createContact("", "");
    private static ContactServiceImpl contactService = ContactServiceImpl.getContactService();

    @Order(1)
    @Test
    void create() {
        Contact createdContact = contactService.create(contact);
        assertNotNull(createdContact);
        System.out.println("Create: " + createdContact);
    }

    @Order(2)
    @Test
    void read() {
        Contact readContact = contactService.read(contact.getContactNumber());
        assertNotNull(readContact);
        System.out.println("Read: " + readContact);
    }

    @Order(3)
    @Test
    void update() {
        Contact updatedContact = new Contact.ContactBuilder().copy(contact)
                .setEmailAddress("anthonypeters@gmail.com")
                .build();
        assertNotNull(contactService.update(updatedContact));
        System.out.println("Updated: " + updatedContact);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = contactService.delete(contact.getContactNumber());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(contactService.getAll());
        assertEquals(1, contactService.getAll().size());
    }
}