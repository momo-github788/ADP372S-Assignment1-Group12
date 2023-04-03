package za.ac.cput.factory;

/*  LocationFactory.java
    Factory for the Location Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import za.ac.cput.domain.Location;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;


public class LocationFactory {

    public static Location createLocation(int streetNumber, String streetName, String city, String postalCode, String province) {

        if(isNullOrEmpty(streetNumber) || isNullOrEmpty(streetName) || isNullOrEmpty(city) || isNullOrEmpty(postalCode) || isNullOrEmpty(province)) {
            return null;
        }

        if(streetNumber < 0) {
            throw new IllegalArgumentException("Street number cannot be a negative value");
        }

        return new Location.LocationBuilder()
                .setLocationId(generateId())
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setCity(city)
                .setPostalCode(postalCode)
                .setProvince(province)
                .build();
    }
}
