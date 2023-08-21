/*
 * WatchListPostFactoryTest.java
 * This is the Factory Test for Branch
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */

package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.util.Helper;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class WatchListPostFactoryTest {

    @Test
    public void testCreateWatchListPost() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost(Helper.generateId(), Helper.generateId());
        assertNotNull(watchListPost.getPostId());
        assertNotNull(watchListPost.getUserId());

        System.out.println(watchListPost);

    }
}
