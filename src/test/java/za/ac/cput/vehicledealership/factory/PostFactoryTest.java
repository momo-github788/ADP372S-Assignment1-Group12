package za.ac.cput.vehicledealership.factory;

/*  PostFactoryTest.java
    Test class for PostFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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


        City city = CityFactory.createCity("Cape Town");
        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);

        Location location = LocationFactory.createLocation(27, "Daisy Street", city, "7850", "Western Cape");

        Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);
        Name name = NameFactory.createName("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "Password123", "Mary@gmail.com");
        Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
                vehicle, branch, true, employee, employee.getEmailAddress());

        System.out.println(post);
        assertNotNull(post);
    }

    @Test
    void testCreatePostWithNullValue() {

        Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
                null, null, true, null, null);

        System.out.println(post);
        assertNull(post);
    }


}
