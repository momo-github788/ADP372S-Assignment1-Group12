/*  IWatchListPostRepository.java
    Repository Interface for Branch Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 6 April 2023
 */

package za.ac.cput.vehicledealership.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.domain.WatchlistPostId;

import java.util.List;
import java.util.Set;

@Repository
public interface WatchListPostRepository extends JpaRepository<WatchListPost, WatchlistPostId> {
    WatchListPost findFirstByPostIdAndUserId(String postId, String userId);
    List<WatchListPost> findAllByUserId(String userId);
}
