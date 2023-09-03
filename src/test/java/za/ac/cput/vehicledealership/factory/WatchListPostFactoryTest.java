///*
// * WatchListPostFactoryTest.java
// * This is the Factory Test for Branch
// * Author: Simphiwe kahlana(220162891)
// * Date : March 2023
// * */
//
//package za.ac.cput.vehicledealership.factory;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import za.ac.cput.vehicledealership.domain.*;
//import za.ac.cput.vehicledealership.util.Helper;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@Disabled
//public class WatchListPostFactoryTest {
//
//    Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
//            "White", 2019, 23000);
//
//    Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
//            7850, "Western Cape");
//
//    ContactDetail contact = ContactDetailFactory.createContact(ContactType.EMAIL, "john@gmail.com");
//    Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);
//    Name name = NameFactory.createName("Mary", "", "Anne");
//    Employee employee = EmployeeFactory.createEmployee(name, "john@gmail.com","Password123");
//    Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
//            vehicle, branch, true, employee, contact.getValue());
//
//    @Test
//    public void testCreateWatchListPost() {
//
//
//        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost(H, Helper.generateId());
//        assertNotNull(watchListPost.getPostId());
//        assertNotNull(watchListPost.getUserId());
//
//        System.out.println(watchListPost);
//
//    }
//}
