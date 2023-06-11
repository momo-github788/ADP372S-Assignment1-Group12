package za.ac.cput.vehicledealership.factory;
/*
    ContactFactory.java
    Factory for Contact Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.util.Helper;

import static za.ac.cput.vehicledealership.util.Helper.isValidMobileNo;

public class ContactFactory {

    public static Contact createContact(String contactNumber, String emailAddress) {
        if (Helper.isNullOrEmpty(contactNumber) || Helper.isNullOrEmpty(emailAddress)) {
            return null;
        }
            if (isValidMobileNo(contactNumber)){
                System.out.println("It is a valid mobile number.");
        }
            else{
                System.out.println("Entered mobile number is invalid");
            }

        return new Contact.ContactBuilder()
                .setContactNumber(contactNumber)
                .setEmailAddress(emailAddress)
                .build();
    }
}
