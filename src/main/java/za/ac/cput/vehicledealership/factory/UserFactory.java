package za.ac.cput.vehicledealership.factory;
/*
    UserFactory.java
    Factory for User Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */

import za.ac.cput.vehicledealership.domain.Contact;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDate;


public class UserFactory {
    public static User createUser(String firstName, String lastName, LocalDate dateJoined, String password, Contact contact){

        return new User.UserBuilder().setUserId(Helper.generateId())
                .setFirstName(firstName).setLastName(lastName)
                .setDateJoined(dateJoined).setPassword(password)
                .setContact(contact)
                .build();
    }
}
