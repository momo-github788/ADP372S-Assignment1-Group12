//package za.ac.cput.vehicledealership.service;
///*  UserServiceImplTest.java
//    Test class for UserServiceImpl
//    Author: Junaid Cedrass (219090912)
//    Date: 11 June 2023
//*/
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.vehicledealership.domain.Contact;
//import za.ac.cput.vehicledealership.domain.User;
//import za.ac.cput.vehicledealership.factory.ContactFactory;
//import za.ac.cput.vehicledealership.factory.UserFactory;
//import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;
//import java.time.LocalDate;
//import static org.junit.jupiter.api.Assertions.*;
//@Disabled
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
//class UserServiceImplTest {
//
//    @Autowired
//    private UserServiceImpl service;
//
//    static LocalDate date = LocalDate.of(1994, 11, 23);
//    static Contact contact = ContactFactory.createContact("0123123412", "JP@gmail.com");
//
//    private static User user = UserFactory.createUser("Johnny","Hoskins", date, "JH12345",contact);
//
//    @Order(1)
//    @Test
//    void create() {
//        User created = service.create(user);
//        assertEquals(user.getUserId(), created.getUserId());
//        System.out.println("Created: " + created);
//    }
//
//    @Order(2)
//    @Test
//    void read() {
//        User read = service.read(user.getUserId());
//        assertNotNull(read);
//        System.out.println("Read: " + read);
//    }
//
//
//    @Order(3)
//    @Test
//    void update() {
//        User newUser= new User.UserBuilder().copy(user)
//                .setLastName("Hopkins")
//                .build();
//        User updated = service.update(newUser);
//        assertEquals(user.getLastName(), updated.getLastName());
//        System.out.println("Updated: " + newUser);
//    }
//
//    @Order(5)
//    @Test
//    @Disabled
//    void delete() {
//        boolean success = service.delete(user.getUserId());
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