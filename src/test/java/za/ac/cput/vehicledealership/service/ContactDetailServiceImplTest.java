package za.ac.cput.vehicledealership.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.factory.ContactDetailFactory;
import za.ac.cput.vehicledealership.service.impl.ContactDetailServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ContactDetailServiceImplTest {
    @Autowired
    private ContactDetailServiceImpl service;
    private static ContactDetail contactDetail = ContactDetailFactory.createContact(ContactType.EMAIL, "juju@gmail.com");

    @Order(1)
    @Test
    void create() {
        ContactDetail created = service.create(contactDetail);
        assertEquals(contactDetail.getContactDetailId(), created.getContactDetailId());
        System.out.println("Created:" + created);
    }

    @Order(2)
    @Test
    void read() {
        ContactDetail read = service.read(contactDetail.getContactDetailId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update() {
        ContactDetail newContactDetail = new ContactDetail.ContactBuilder().copy(contactDetail)
                .setValue("juju2.0@gmail.com")
                .build();
        ContactDetail updated = service.update(newContactDetail);
        assertEquals("juju2.0@gmail.com", updated.getValue());
        System.out.println("Updated: " + newContactDetail);
    }

    @Order(5)
    @Test
    void delete() {
        boolean success = service.delete(contactDetail.getContactDetailId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Order(4)
    @Test
    void getAll() {
        System.out.println("Get all: ");
        System.out.println(service.getAll());
    }
}