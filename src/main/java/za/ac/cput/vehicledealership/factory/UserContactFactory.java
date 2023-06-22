package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.UserContact;
import za.ac.cput.vehicledealership.util.Helper;

/*  UserContactFactory.java
    Factory for user contact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
public class UserContactFactory {

    public static UserContact createUserContact(Contact contact){
        if(Helper.isNullOrEmpty(contact) ){
            return null;
        }
        return new UserContact.Builder()
                .setUserId(Helper.generateId())
                .setContact(contact)
                .build();
    }

}
