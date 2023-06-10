package za.ac.cput.vehicledealership.factory;

/*  PostFactoryTest.java
    Test class for PostFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.factory.BranchFactory;
import za.ac.cput.vehicledealership.factory.LocationFactory;
import za.ac.cput.vehicledealership.factory.PostFactory;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.*;

class PostFactoryTest {

    private String vehicleId;
    private String make;
    private String model;
    private VehicleCondition condition;
    private FuelType fuelType;
    private String colour;
    private int year;
    private int mileage;

    @Test
    void testCreatePostSuccess() {

        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town", "7850", "Western Cape");

        Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

        Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
                vehicle, branch, true);

        System.out.println(post);
        assertNotNull(post);
    }

    @Test
    void testCreatePostWithNullValue() {

        Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
                null, null, true);

        System.out.println(post);
        assertNull(post);
    }


}
