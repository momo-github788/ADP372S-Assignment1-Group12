package za.ac.cput.vehicledealership.repository;

/*  IPostRepository.java
    Repository Interface for Post Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import za.ac.cput.vehicledealership.domain.Post;

import java.util.Set;

public interface PostRepository extends IRepository<Post, String> {

    Set<Post> getAll();
}
