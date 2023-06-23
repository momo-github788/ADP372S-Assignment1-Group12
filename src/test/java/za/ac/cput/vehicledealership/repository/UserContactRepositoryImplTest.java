package za.ac.cput.vehicledealership.repository;
/*  UserContactRepositoryImplTest.java
    Test class for UserContact Repository
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June2023
*/
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.factory.UserContactFactory;
import za.ac.cput.vehicledealership.repository.impl.UserContactRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserContactRepositoryImplTest {
    private static UserContactRepositoryImpl userContactRepository = UserContactRepositoryImpl.getUserContactRepository();

    private static Contact contact = ContactFactory.createContact("0629390280", "geocharimba@gmail.com");
    private static UserContact userContact = UserContactFactory.createUserContact(contact);


    @Order(1)
    @Test
    void create() {
        UserContact createdUserContact= userContactRepository.create(userContact);
        assertNotNull(createdUserContact);
        System.out.println("Create: " + createdUserContact);
    }

    @Order(2)
    @Test
    void read() {
        UserContact readUserContact = userContactRepository.read(userContact.getUserId());
        assertNotNull(readUserContact);
        System.out.println("Read: " + readUserContact);
    }

    @Order(3)
    @Test
    void update() {
        UserContact updatedUserContact = new UserContact.Builder()
                .copy(userContact)
                .build();
        assertNotNull(userContactRepository.update(updatedUserContact));
        System.out.println("Update: " + updatedUserContact);


    }

    @Order(5)
    @Test
    void delete() {
        boolean success = userContactRepository.delete(userContact.getUserId());

        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(userContactRepository.getAll());
        assertEquals(1, userContactRepository.getAll().size());
    }
}
