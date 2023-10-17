package za.ac.cput.vehicledealership.service;
/*  UserServiceImplTest.java
    Test class for UserServiceImpl
    Author: Junaid Cedrass (219090912)
    Date: 11 June 2023
*/
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.domain.User;

import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.impl.AuthenticationService;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserServiceImpl userService;
    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static User user = UserFactory.createUser(name, "P@ssword123", "mary@gmail.com");

    private static RegisterRequest request = new RegisterRequest(name, user.getEmailAddress(), user.getPassword());


    private static int userId;

    @Order(1)
    @Test
    void create() {
        User created = authenticationService.registerUser(request);

        assertNotNull(created);
        System.out.println("Created: " + created);
        userId = created.getUserId();
    }

    @Order(2)
    @Test
    void read() {
        User read = userService.read(userId);
        assertNotNull(read);
        System.out.println("Read: " + read);
    }


    @Order(3)
    @Test
    void update() {


        Name middleName = NameFactory.createName("Julian");

        User newUser= new User.UserBuilder().copy(user)
                .setName(middleName)
                .build();

        newUser.setUserId(userId);

        User updated = userService.update(newUser);


        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = userService.delete(userId);
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(userService.getAll());
    }
}