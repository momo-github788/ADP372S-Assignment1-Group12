/*
 * WatchListPostFactory.java
 * This is the Fa tory for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */

package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.util.Helper;

public class WatchListPostFactory {
    public static WatchListPost createWatchListPost(String postId, String userId) {
        return new WatchListPost.Builder()
                .setPostId(postId)
                .setUserId(userId)
                .build();
    }
}

