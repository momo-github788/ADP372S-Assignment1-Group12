

package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.WatchListPost;

import static org.junit.jupiter.api.Assertions.*;

public class WatchListPostFactoryTest {
    @Test
    public void testCreateWatchListPost() {
        Integer watchListPostId = 1;
        String postId = "post1";
        String userId = "user1";

        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost(watchListPostId, postId, userId);

        assertEquals(watchListPostId, watchListPost.getWatchListPostId());
        assertEquals(postId, watchListPost.getPostId());
        assertEquals(userId, watchListPost.getUserId());
    }
}
