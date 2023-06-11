/*  IWatchListPostRepository.java
    Repository Interface for Branch Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 6 April 2023
 */

package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.WatchListPost;

import java.util.Set;

public interface WatchListPostRepository extends IRepository<WatchListPost, String >{
    Set<WatchListPost> getAll();
}
