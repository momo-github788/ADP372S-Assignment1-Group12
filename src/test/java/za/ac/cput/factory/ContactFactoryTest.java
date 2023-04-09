package za.ac.cput.factory;
/*  ContactTest.java
    Factory Test for Contact Entity
    Author: Junaid Cedrass(219090912)
    Date: 4 April 2023
*/
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
