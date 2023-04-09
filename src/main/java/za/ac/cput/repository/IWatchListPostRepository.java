/*  IWatchListPostRepository.java
    Repository Interface for Branch Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 6 April 2023
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Branch;
import za.ac.cput.domain.WatchListPost;

import java.util.Set;

public interface IWatchListPostRepository extends IRepository<WatchListPost, String >{
    Set<WatchListPost> getAll();
}
