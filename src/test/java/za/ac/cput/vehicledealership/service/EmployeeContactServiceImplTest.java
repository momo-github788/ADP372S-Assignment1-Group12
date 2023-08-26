//package za.ac.cput.vehicledealership.service;
///*  EmployeeContactSerciveImplTest.java
//    Test class for EmplpyeeContactServiceImpl
//    Author: George Tapiwa Charimba (220073465)
//    Date: 23 June 2023
//*/
//import org.junit.jupiter.api.*;
//import za.ac.cput.vehicledealership.domain.AddonType;
//import za.ac.cput.vehicledealership.domain.Addons;
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.domain.EmployeeContact;
//import za.ac.cput.vehicledealership.factory.AddonsFactory;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.factory.EmployeeContactFactory;
//import za.ac.cput.vehicledealership.service.impl.EmployeeContactServiceImpl;
//
//import java.time.LocalDateTime;
//import static org.junit.jupiter.api.Assertions.*;
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class EmployeeContactServiceImplTest {
//
//    private static EmployeeContactServiceImpl employeeContactService = EmployeeContactServiceImpl.getEmployeeContactService();
//
//    private static Contact contact = ContactFactory.createContact("0629390280", "geocharimba@gmail.com");
//    private static EmployeeContact employeeContact = EmployeeContactFactory.createEmployeeContact(contact);
//
//
//    @Order(1)
//    @Test
//    void create() {
//        EmployeeContact createdEmployeeContact = employeeContactService.create(employeeContact);
//        assertNotNull(createdEmployeeContact);
//        System.out.println("Create: " + createdEmployeeContact);
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//        EmployeeContact readEmployeeContact = employeeContactService.read(employeeContact.getEmployeeNumber());
//        assertNotNull(readEmployeeContact);
//        System.out.println("Read: " + readEmployeeContact);
//    }
//
//    @Order(3)
//    @Test
//    void update() {
//        EmployeeContact updatedEmployeeContact = new EmployeeContact.Builder()
//                .copy(employeeContact)
//                .build();
//        assertNotNull(employeeContactService.update(updatedEmployeeContact));
//        System.out.println("Update: " + updatedEmployeeContact);
//
//    }
//
//    @Order(5)
//    @Test
//    void delete() {
//        boolean success = employeeContactService.delete(employeeContact.getEmployeeNumber());
//
//        assertTrue(success);
//        System.out.println("Delete: " + success);
//    }
//
//    @Order(4)
//    @Test
//    void getAll() {
//        System.out.println("Get all: ");
//        System.out.println(employeeContactService.getAll());
//        assertEquals(1, employeeContactService.getAll().size());
//    }
//}