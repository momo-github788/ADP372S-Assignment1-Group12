package za.ac.cput.vehicledealership.service;

/*  WatchListPostServiceImplTest.java
    Test class for WatchListPostServiceImpl
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.factory.*;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.impl.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class WatchListPostServiceImplTest {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private WatchListPostServiceImpl watchListPostService;
    @Autowired
    private PostServiceImpl postService;
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private BranchServiceImpl branchService;


    private static Name userName = NameFactory.createName("Mary", "", "Anne");
    private static User user = UserFactory.createUser(userName, "password123", "mary@gmail.com");

//    private static ContactDetail contact = ContactDetailFactory.createContact(ContactType.EMAIL, "mary@gmail.com");

    private static Location location = LocationFactory.createLocation(27, "Daisy Street", "Cape Town",
            7850, "Western Cape");
    private static Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, BodyType.SEDAN,
            "White", 2019, 23000);
    private static Branch branch = BranchFactory.createBranch("Cape town branch", 2017, location);

    private static Name employeeName = NameFactory.createName("John", "James", "Doe");
    private static Employee employee = EmployeeFactory.createEmployee(employeeName, "john@gmail.com","P@ssword123");

    private static Post post = PostFactory.createPost("Audi A4 For sale", "Car is in good condition. License up to date", 249999.99,
            vehicle, branch, true, employee, employee.getEmailAddress());




    @Test
    public void testCreate() {
        User theUser = authenticationService.registerUser(new RegisterRequest(userName, user.getEmailAddress(), user.getPassword()));
        Employee theEmployee = authenticationService.registerEmployee(new RegisterRequest(employee.getName(), employee.getEmailAddress(), employee.getPassword()));

        Branch theBranch = branchService.create(branch);
        post.setBranch(theBranch);
        Post thePost = postService.create(post, employee.getEmailAddress());


        theEmployee.setPosts(List.of(thePost));

        WatchListPost createdWatchListPost = watchListPostService.create(thePost.getPostId(), theUser.getEmailAddress());
        System.out.println(createdWatchListPost);
        assertNotNull(createdWatchListPost);
    }
}
