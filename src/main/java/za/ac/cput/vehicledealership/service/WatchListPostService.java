/*  WatchListPostService.java
    Service Interface for WatchListPost Domain
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service;


import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.domain.WatchlistPostId;

import java.util.Set;

public interface WatchListPostService extends IService<WatchListPost, WatchlistPostId> {
    Set<WatchListPost> getAll();
}
