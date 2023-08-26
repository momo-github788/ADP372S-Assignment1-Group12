package za.ac.cput.vehicledealership.repository;

/*  IPostRepository.java
    Repository Interface for Post Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    Post findPostByPostId(String postId);
    Boolean existsByTitle(String title);
    List<Post> findAllByPostIdIn(List<String> postIdList);
}
