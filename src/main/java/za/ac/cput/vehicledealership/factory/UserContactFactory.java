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

    public static UserContact createUserContact(String userId, String contactId){
        if(Helper.isNullOrEmpty(userId) || Helper.isNullOrEmpty(contactId)){
            return null;
        }
        return new UserContact.Builder()
                .setUserId(userId)
                .setContactId(contactId)
                .build();
    }

}
