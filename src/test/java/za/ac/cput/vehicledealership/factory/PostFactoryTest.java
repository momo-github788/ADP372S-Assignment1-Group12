package za.ac.cput.vehicledealership.factory;

/*  PostFactoryTest.java
    Test class for PostFactory
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
@Disabled
class PostFactoryTest {

    @Test
    void testCreatePostSuccess() {

        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL,
                "White", 2019, 23000);

        Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
                7850, "Western Cape");

        Contact contact = ContactFactory.createContact(ContactType.EMAIL, "john@gmail.com");
        Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);
        Name name = NameFactory.createName("Mary", "", "Anne");
        Employee employee = EmployeeFactory.createEmployee(name, "Password123");
        Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
                vehicle, branch, true, employee, contact.getValue());

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
