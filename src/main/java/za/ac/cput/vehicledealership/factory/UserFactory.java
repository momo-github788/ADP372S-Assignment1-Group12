package za.ac.cput.vehicledealership.factory;
/*
    UserFactory.java
    Factory for User Entity
    Junaid Cedrass - 219090912
    04 April 2023
 */

import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDate;


public class UserFactory {
    public static User createUser(Name name, String password, String emailAddress){
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(password)) {
            return null;
        }
        return new User.UserBuilder()
                .setName(name)
                .setDateJoined(LocalDate.now())
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }
}
