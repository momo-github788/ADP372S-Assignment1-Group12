package za.ac.cput.vehicledealership.factory;

/*  PostFactory.java
    Factory for the Post Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import za.ac.cput.vehicledealership.domain.*;
import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDateTime;


public class PostFactory {

    public static Post createPost(String title, String description, double price, Vehicle vehicle, Branch branch, boolean isActive, Employee employee,  String postCreatorEmail) {

        if(Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(price) ||
                Helper.isNullOrEmpty(isActive) || Helper.isNullOrEmpty(postCreatorEmail)) {
            return null;
        }

        Name createdName = NameFactory.createName(employee.getName().getFirstName(), employee.getName().getMiddleName(), employee.getName().getLastName());
        Location createdLocation = LocationFactory.createLocation(branch.getLocation().getStreetNumber(),
                branch.getLocation().getStreetName(), branch.getLocation().getCity(), branch.getLocation().getPostalCode(), branch.getLocation().getProvince());
        Branch createdBranch = BranchFactory.createBranch(branch.getBranchName(), branch.getYearOpened(), createdLocation);
        Employee createdEmployee = EmployeeFactory.createEmployee(createdName, employee.getEmailAddress(), employee.getPassword());

        return new Post.Builder()
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setVehicle(vehicle)
                .setBranch(createdBranch)
                .setCreatedAt(LocalDateTime.now())
                .setExpiredAt(LocalDateTime.now().plusMonths(2))
                .setActive(isActive)
                .setPostCreatorEmail(postCreatorEmail)
                .setEmployee(createdEmployee)
                .build();
    }
}