//package za.ac.cput.vehicledealership.service;
///*  ContactServiceImplTest.java
//    Test class for ContactServiceImpl
//    Author: Junaid Cedrass (219090912)
//    Date: 11 June 2023
//*/
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.service.impl.ContactServiceImpl;
//import static org.junit.jupiter.api.Assertions.*;
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
//class ContactServiceImplTest {
//
//    @Autowired
//    private ContactServiceImpl service;
//
//    private static Contact contact = ContactFactory.createContact("0213569812", "alanj@yahoo.com");
//
//
//    @Order(1)
//    @Test
//    void create() {
//        Contact created = service.create(contact);
//        assertEquals(contact.getContactNumber(), created.getContactNumber());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//        Contact read = service.read(contact.getContactNumber());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//    @Order(3)
//    @Test
//    void update() {
//        Contact newContact = new Contact.ContactBuilder().copy(contact)
//                .setEmailAddress("anthonypeters@gmail.com")
//                .build();
//        Contact updated = service.update(newContact);
//        assertEquals(contact.getEmailAddress(), updated.getEmailAddress());
//        System.out.println("Updated: " + newContact);
//    }
//
//    @Order(5)
//    @Test
//    @Disabled
//    void delete() {
//        boolean success = service.delete(contact.getContactNumber());
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Order(4)
//    @Test
//    void getAll() {
//        System.out.println("Get all: ");
//        System.out.println(service.getAll());
//    }
//}