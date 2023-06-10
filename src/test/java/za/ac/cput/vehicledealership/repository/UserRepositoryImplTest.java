package za.ac.cput.vehicledealership.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import za.ac.cput.vehicledealership.factory.UserFactory;
import za.ac.cput.vehicledealership.repository.impl.UserRepositoryImpl;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class UserRepositoryImplTest {
    private static UserRepositoryImpl repository = UserRepositoryImpl.getRepository();
    static LocalDate date = LocalDate.of(2001, 03, 15);
   static Contact contact = ContactFactory.createContact("0210434353", "michealjames@gmail.com");
    private static User user = UserFactory.createUser("Jason", "Williams", date, "213123123", contact);

    @Test
    void a_create() {
        User created = repository.create(user);
        assertEquals(user.getUserId(), created.getUserId());
        System.out.println("Create:" + created);
    }

    @Test
    void b_read() {
        User read = repository.read(user.getUserId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        User updated = new User.UserBuilder().copy(user).setFirstName("Nathan")
                .setLastName("Petersen")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }
    @Test
    void e_delete() {
        boolean success = repository.delete(user.getUserId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}