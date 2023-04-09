/*
 * WatchListPostFactoryTest.java
 * This is the Factory Test for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */

package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.WatchListPost;


public class WatchListPostFactoryTest {

    @Test
    public void testCreateWatchListPost() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        assertNotNull(watchListPost.getWatchListPostId());
        assertNotNull(watchListPost.getPostId());
        assertNotNull(watchListPost.getUserId());

        System.out.println(watchListPost);

    }
}
