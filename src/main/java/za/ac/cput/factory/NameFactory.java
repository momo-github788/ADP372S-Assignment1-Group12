package za.ac.cput.factory;

/*  NameFactory.java
    Factory for the Name entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 May 2023
*/

import za.ac.cput.domain.Name;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class NameFactory {
    public static Name createNameFactory(String firstName, String middleName, String lastName) {

        if(isNullOrEmpty(firstName) || isNullOrEmpty(middleName) || isNullOrEmpty(lastName)) {
            return null;
        }

        return new Name.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }
}
