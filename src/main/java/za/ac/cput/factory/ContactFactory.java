package za.ac.cput.factory;
/*
    ContactFactory.java
    Factory for Contact Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */
import za.ac.cput.domain.Contact;

public class ContactFactory {
    public static Contact createContact(String contactNumber, String emailAddress){
        return new Contact.ContactBuilder()
                .setContactNumber(contactNumber)
                .setEmailAddress(emailAddress)
                .build();
    }
}
