package za.ac.cput.vehicledealership.factory;
/*  EmployeeContactFactory.java
    Factory for the EmployeeContact Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.EmployeeContact;
import za.ac.cput.vehicledealership.domain.EmployeeContactId;
import za.ac.cput.vehicledealership.util.Helper;

import static za.ac.cput.vehicledealership.util.Helper.*;

public class EmployeeContactFactory {

    public static EmployeeContact createEmployeeContact(String employeeNumber, String contactId){
        if(Helper.isNullOrEmpty(contactId) || isNullOrEmpty(employeeNumber)){
            return null;
        }
        return new EmployeeContact.Builder()
                .setEmployeeNumber(employeeNumber)
                .setContactId(contactId)
                .build();
    }
}
