package za.ac.cput.vehicledealership.factory;

/*  PostFactory.java
    Factory for the Post Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/

import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDateTime;


public class PostFactory {


    public static Post createPost(String title, String description, double price, Vehicle vehicle, Branch branch, boolean isActive) {

        if(Helper.isNullOrEmpty(title) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(price) || Helper.isNullOrEmpty(vehicle) || Helper.isNullOrEmpty(branch) || Helper.isNullOrEmpty(isActive)) {
            return null;
        }

        return new Post.Builder()
                .setPostId(Helper.generateId())
                .setTitle(title)
                .setDescription(description)
                .setPrice(price)
                .setVehicle(vehicle)
                .setBranch(branch)
                .setCreatedAt(LocalDateTime.now())
                .setExpiredAt(LocalDateTime.now().plusMonths(2))
                .setActive(isActive)
                .build();
    }
}