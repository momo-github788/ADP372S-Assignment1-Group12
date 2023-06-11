package za.ac.cput.vehicledealership.service;

/*  WatchListPostServiceImplTest.java
    Test class for WatchListPostServiceImpl
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.factory.WatchListPostFactory;


import java.util.Set;

public class WatchListPostServiceImplTest {
    private za.ac.cput.vehicledealership.repository.impl.WatchListPostRepositoryimpl WatchListPostRepositoryimpl;

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
