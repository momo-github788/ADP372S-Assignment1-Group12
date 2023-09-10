package za.ac.cput.vehicledealership.repository;

/*  IPostRepository.java
    Repository Interface for Post Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 6 April 2023
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByPostId(int postId);
    List<Post> findAllByTitleContaining(String title);
    List<Post> findAllByPostCreatorEmail(String emailAddress);
    Boolean existsByTitle(String title);

//    @Query("SELECT p FROM Post p JOIN FETCH p.vehicle v WHERE v.condition = :condition OR v.fuelType = :fueltype OR v.make = :make")
//    List<Post> getAll(VehicleCondition condition, FuelType fuelType, String make);
    List<Post> findAllByPostIdIn(List<Integer> postIdList);
}
