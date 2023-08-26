//package za.ac.cput.vehicledealership.service;
///*  AddonsSerciveImplTest.java
//    Test class for AddonsServiceImpl
//    Author: George Tapiwa Charimba (220073465)
//    Date: 11 June 2023
//*/
//import org.junit.jupiter.api.*;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.factory.UserContactFactory;
//import za.ac.cput.vehicledealership.service.impl.UserContactServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.*;
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class UserContactServiceImplTest {
//
//    private static UserContactServiceImpl userContactService = UserContactServiceImpl.getUserContactService();
//
//    private static Contact contact = ContactFactory.createContact("0629390280", "geocharimba@gmail.com");
//    private static UserContact userContact = UserContactFactory.createUserContact(contact);
//
//
//    @Order(1)
//    @Test
//    void create() {
//        UserContact createdUserContact = userContactService.create(userContact);
//        assertNotNull(createdUserContact);
//        System.out.println("Create: " + createdUserContact);
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//        UserContact readUserContact = userContactService.read(userContact.getUserId());
//        assertNotNull(readUserContact);
//        System.out.println("Read: " + readUserContact);
//    }
//
//    @Order(3)
//    @Test
//    void update() {
//        UserContact updatedUserContact = new UserContact.Builder()
//                .copy(userContact)
//                .build();
//        assertNotNull(userContactService.update(updatedUserContact));
//        System.out.println("Update: " + updatedUserContact);
//
//    }
//
//    @Order(5)
//    @Test
//    void delete() {
//        boolean success = userContactService.delete(userContact.getUserId());
//
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Order(4)
//    @Test
//    void getAll() {
//        System.out.println("Get all: ");
//        System.out.println(userContactService.getAll());
//        assertEquals(1, userContactService.getAll().size());
//    }
//}
