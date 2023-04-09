package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContactFactoryTest {
    @Test
    public void test(){
        Contact contact = ContactFactory.createContact("1231223412L", "michealjames@gmail.com" );
        assertNotNull(contact);
        System.out.println(contact.toString());
    }
}
