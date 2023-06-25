package za.ac.cput.vehicledealership.factory;


/*  LocationFactoryTest.java
    Test class for LocationFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.City;
import za.ac.cput.vehicledealership.domain.Location;

import static org.junit.jupiter.api.Assertions.*;

class LocationFactoryTest {

    private static City city = CityFactory.createCity("Cape Town");

    @Test
    public void testCreateLocationSuccess() {
        Location location = LocationFactory.createLocation(27, "Daisy Street", city, "7850", "Western Cape");

        System.out.println(location);
        assertNotNull(location);
    }


    @Test
    public void testCreateLocationWithNullValue() {
        Location location = LocationFactory.createLocation(27, "", city, "7850", "Western Cape");

        System.out.println(location);
        assertNull(location);
    }

    @Test
    public void testCreateLocationExceptionWithNegativeStreetNumber() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> LocationFactory.createLocation(-999, "Daisy Street", city, "7850", "Western Cape"));
        System.out.println(exception);

        assertTrue(exception.getMessage().contentEquals("Street number cannot be a negative value"));
    }



}