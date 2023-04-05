package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {
    @Test
    public void test(){
        Contact contact = ContactFactory.createContact("1231223412L", "michealjames@gmail.com" );
        System.out.println(contact.toString());
        assertNotNull(contact);
    }
}