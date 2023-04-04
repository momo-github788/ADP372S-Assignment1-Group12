/*
 * WatchListPostFactory.java
 * This is the Fa tory for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.WatchListPost;

public class WatchListPostFactory {
    public static WatchListPost createWatchListPost(Integer watchListPostId, String postId, String userId) {
        return new WatchListPost.Builder()
                .withWatchListPostId(watchListPostId)
                .withPostId(postId)
                .withUserId(userId)
                .build();
    }
}
