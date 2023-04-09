/*  WatchListPostRepositoryTestTest.java
    Test class for WatchListPostRepository
    Author: Simphiwekahlana (220162891)
    Date: 6 April 2023
*/

package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.WatchListPost;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.WatchListPostFactory;

import java.util.Set;

public class WatchListPostRepositoryTest {

    private WatchListPostRepository watchListPostRepository;

    @BeforeEach
    public void setUp() {
        watchListPostRepository = WatchListPostRepository.getWatchListPostRepository();
    }

    @Test
    public void testCreate() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        WatchListPost createdWatchListPost = watchListPostRepository.create(watchListPost);
        Assertions.assertNotNull(createdWatchListPost);
        Assertions.assertEquals(watchListPost, createdWatchListPost);
    }

    @Test
    public void testRead() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        watchListPostRepository.create(watchListPost);
        WatchListPost readWatchListPost = watchListPostRepository.read(watchListPost.getWatchListPostId());
        Assertions.assertNotNull(readWatchListPost);
        Assertions.assertEquals(watchListPost, readWatchListPost);
    }

    @Test
    public void testUpdate() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        watchListPostRepository.create(watchListPost);
        WatchListPost updatedWatchListPost = WatchListPostFactory.createWatchListPost();
        updatedWatchListPost.setWatchListPostId(watchListPost.getWatchListPostId());
        watchListPostRepository.update(updatedWatchListPost);
        WatchListPost readWatchListPost = watchListPostRepository.read(watchListPost.getWatchListPostId());
        Assertions.assertEquals(updatedWatchListPost, readWatchListPost);
    }

    @Test
    public void testDelete() {
        WatchListPost watchListPost = WatchListPostFactory.createWatchListPost();
        watchListPostRepository.create(watchListPost);
        boolean deleted = watchListPostRepository.delete(watchListPost.getWatchListPostId());
        Assertions.assertTrue(deleted);
        WatchListPost readWatchListPost = watchListPostRepository.read(watchListPost.getWatchListPostId());
        Assertions.assertNull(readWatchListPost);
    }

    @Test
    public void testGetAll() {
        WatchListPost watchListPost1 = WatchListPostFactory.createWatchListPost();
        WatchListPost watchListPost2 = WatchListPostFactory.createWatchListPost();
        watchListPostRepository.create(watchListPost1);
        watchListPostRepository.create(watchListPost2);
        Set<WatchListPost> watchListPosts = watchListPostRepository.getAll();
        Assertions.assertEquals(2, watchListPosts.size());
        Assertions.assertTrue(watchListPosts.contains(watchListPost1));
        Assertions.assertTrue(watchListPosts.contains(watchListPost2));
    }

}
