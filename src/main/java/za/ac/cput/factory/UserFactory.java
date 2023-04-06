package za.ac.cput.factory;
/*
    UserFactory.java
    Factory for User Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static za.ac.cput.util.Helper.generateId;


public class UserFactory {
    public static User createUser(String firstName, String lastName, LocalDate dateJoined, String password, Contact contact){

        return new User.UserBuilder().setUserId(generateId())
                .setFirstName(firstName).setLastName(lastName)
                .setDateJoined(dateJoined).setPassword(password)
                .setContact(contact)
                .build();
    }
}
