/*  WatchListPostRepositoryTestTest.java
    Test class for WatchListPostRepository
    Author: Simphiwekahlana (220162891)
    Date: 6 April 2023
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.WatchListPost;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.factory.WatchListPostFactory;

import java.util.Set;

public class WatchListPostRepositoryImplTest {

    private WatchListPostRepositoryimpl WatchListPostRepositoryimpl;

    @BeforeEach
    public void setUp() {
        WatchListPostRepositoryimpl = WatchListPostRepositoryimpl.getWatchListPostRepository();
    }

    @Test
    public void testCreate() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        WatchListPost createdWatchListPost = WatchListPostRepositoryimpl.create(watchListPost);
        Assertions.assertNotNull(createdWatchListPost);
        Assertions.assertEquals(watchListPost, createdWatchListPost);
    }

    @Test
    public void testRead() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        WatchListPostRepositoryimpl.create(watchListPost);
        WatchListPost readWatchListPost = WatchListPostRepositoryimpl.read(watchListPost.getWatchListPostId());
        Assertions.assertNotNull(readWatchListPost);
        Assertions.assertEquals(watchListPost, readWatchListPost);
    }

    @Test
    public void testUpdate() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        WatchListPostRepositoryimpl.create(watchListPost);
        WatchListPost updatedWatchListPost = WatchListPostFactory.createWatchListPost();
        updatedWatchListPost.setWatchListPostId(watchListPost.getWatchListPostId());
        WatchListPostRepositoryimpl.update(updatedWatchListPost);
        WatchListPost readWatchListPost = WatchListPostRepositoryimpl.read(watchListPost.getWatchListPostId());
        Assertions.assertEquals(updatedWatchListPost, readWatchListPost);
    }

    @Test
    public void testDelete() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        WatchListPostRepositoryimpl.create(watchListPost);
        boolean deleted = WatchListPostRepositoryimpl.delete(watchListPost.getWatchListPostId());
        Assertions.assertTrue(deleted);
        WatchListPost readWatchListPost = WatchListPostRepositoryimpl.read(watchListPost.getWatchListPostId());
        Assertions.assertNull(readWatchListPost);
    }

    @Test
    public void testGetAll() {
        WatchListPost watchListPost1 = WatchListPostFactory.createWatchListPost();
        WatchListPost watchListPost2 = WatchListPostFactory.createWatchListPost();
        WatchListPostRepositoryimpl.create(watchListPost1);
        WatchListPostRepositoryimpl.create(watchListPost2);
        Set<WatchListPost> watchListPosts = WatchListPostRepositoryimpl.getAll();
        Assertions.assertEquals(4, watchListPosts.size());
        Assertions.assertTrue(watchListPosts.contains(watchListPost1));
        Assertions.assertTrue(watchListPosts.contains(watchListPost2));
    }

}
