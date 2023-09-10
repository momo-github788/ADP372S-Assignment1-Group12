package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;

import static org.junit.jupiter.api.Assertions.assertNotNull;



class ContactDetailsFactoryTest {
    @Test
    public void test(){
        ContactDetail contact = ContactDetailFactory.createContact(ContactType.EMAIL, "michealjames@gmail.com" );
        assertNotNull(contact);
        System.out.println(contact.toString());
    }
}
