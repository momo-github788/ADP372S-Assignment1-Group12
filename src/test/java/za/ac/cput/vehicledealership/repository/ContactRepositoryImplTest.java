package za.ac.cput.vehicledealership.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.factory.ContactFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactRepositoryImplTest {
    private static ContactRepositoryImpl contactRepository = ContactRepositoryImpl.getContactRepository();
  private static Contact contact = ContactFactory.createContact("121231234", "johanness@yahoo.com");

    @Test
    void a_create() {
        Contact created = contactRepository.create(contact);
        assertEquals(contact.getContactNumber(),created.getContactNumber());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Contact read = contactRepository.read(contact.getContactNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Contact updated = new Contact.ContactBuilder().copy(contact)
                .setEmailAddress("jp3@yahoo.com")
                .build();
        assertNotNull(contactRepository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = contactRepository.delete(contact.getContactNumber());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(contactRepository.getAll());
    }
}