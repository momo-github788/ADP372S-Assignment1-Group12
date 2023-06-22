package za.ac.cput.vehicledealership.factory;
/*  EmployeeContactFactory.java
    Factory for the EmployeeContact Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.util.Helper;

import static za.ac.cput.vehicledealership.util.Helper.generateNumericId;

public class EmployeeContactFactory {

    public static EmployeeContact createEmployeeContact(Contact contact){
        if(Helper.isNullOrEmpty(contact)){
            return null;
        }
        return new EmployeeContact.Builder()
                .setEmployeeNumber(generateNumericId())
                .setContact(contact)
                .build();
    }
}
