package za.ac.cput.vehicledealership.service;

/*  PostService.java
    Service Interface for Post Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Post;
import java.util.Set;

public interface PostService extends IService<Post, String>{
    Set<Post> getAll();
}
