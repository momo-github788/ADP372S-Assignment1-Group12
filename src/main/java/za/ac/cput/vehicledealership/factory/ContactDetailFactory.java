package za.ac.cput.vehicledealership.factory;
/*
    ContactFactory.java
    Factory for Contact Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.util.Helper;

import java.util.Set;

import static za.ac.cput.vehicledealership.util.Helper.isValidEmail;
import static za.ac.cput.vehicledealership.util.Helper.isValidMobileNo;

public class ContactDetailFactory {

    public static ContactDetail createContact(ContactType contactType, String value) {
        if (Helper.isNullOrEmpty(contactType) || Helper.isNullOrEmpty(value)) {
            return null;
        }

        System.out.println("Contact type: " + contactType);
        // Enum for different types of contacts
       if(contactType.name().equalsIgnoreCase("EMAIL")) {
            if (!isValidEmail(value)){
                System.out.println("Entered email address is invalid");
                throw new RuntimeException("Entered email address is invalid");
            }
        } else if(contactType.name().equalsIgnoreCase("MOBILE")) {
            if (!isValidMobileNo(value)){
                System.out.println("Entered mobile number is invalid");
                throw new RuntimeException("Entered mobile number is invalid");
            }
        }


        return new ContactDetail.ContactBuilder()
                .setContactType(contactType)
                .setValue(value)
                .build();
    }
}
