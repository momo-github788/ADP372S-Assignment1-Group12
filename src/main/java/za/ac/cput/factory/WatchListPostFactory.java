/*
 * WatchListPostFactory.java
 * This is the Fa tory for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.WatchListPost;

import static za.ac.cput.util.Helper.generateId;

public class WatchListPostFactory {
    public static WatchListPost createWatchListPost() {
        return new WatchListPost.Builder()
                .setWatchListPostId(generateId())
                .setPostId(generateId())
                .setUserId(generateId())
                .build();
    }
}

