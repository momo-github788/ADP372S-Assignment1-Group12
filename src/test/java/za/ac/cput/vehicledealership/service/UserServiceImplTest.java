package za.ac.cput.vehicledealership.service;
/*  UserServiceImplTest.java
    Test class for UserServiceImpl
    Author: Junaid Cedrass (219090912)
    Date: 11 June 2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceImplTest {
    static LocalDate date = LocalDate.of(1994, 11, 23);
    static Contact contact = ContactFactory.createContact("0123123412", "JP@gmail.com");
    private static User user = UserFactory.createUser("Johnny","Hoskins", date, "JH12345",contact);

    private static UserServiceImpl userService = UserServiceImpl.getUserService();
    @Order(1)
    @Test
    void create() {
        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        System.out.println("Create: " + createdUser);
    }

    @Order(2)
    @Test
    void read() {
        User readUser = userService.read(user.getUserId());
        assertNotNull(readUser);
        System.out.println("Read: " + readUser);
    }


    @Order(3)
    @Test
    void update() {
        User updatedUser = new User.UserBuilder().copy(user)
                .setLastName("Hopkins")
                .build();
        assertNotNull(userService.update(updatedUser));
        System.out.println("Updated: " + updatedUser);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = userService.delete(user.getUserId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(userService.getAll());
        assertEquals(1,userService.getAll().size());
    }
}