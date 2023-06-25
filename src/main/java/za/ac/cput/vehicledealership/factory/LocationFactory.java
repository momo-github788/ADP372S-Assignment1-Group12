package za.ac.cput.vehicledealership.factory;

/*  LocationFactory.java
    Factory for the Location Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import za.ac.cput.vehicledealership.domain.City;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.util.Helper;

import static za.ac.cput.vehicledealership.util.Helper.generateId;

public class LocationFactory {

    public static Location createLocation(int streetNumber, String streetName, City city, String postalCode, String province) {

        if(Helper.isNullOrEmpty(String.valueOf(streetNumber)) || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(postalCode) || Helper.isNullOrEmpty(province)) {
            return null;
        }

        if(streetNumber < 0) {
            throw new IllegalArgumentException("Street number cannot be a negative value");
        }

        return new Location.Builder()
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setCity(city)
                .setPostalCode(postalCode)
                .setProvince(province)
                .build();
    }
}
