package za.ac.cput.vehicledealership.repository;

/*  IPostRepository.java
    Repository Interface for Post Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vehicledealership.domain.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}
