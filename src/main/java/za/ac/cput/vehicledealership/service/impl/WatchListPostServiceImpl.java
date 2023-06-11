/*  WatchListPostServiceImpl.java
    Implementation of the WatchListPostService
    Author: Simphiwe Kahlana (220162891)
    Date: 09 June 2023
*/

package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.WatchListPost;
import za.ac.cput.vehicledealership.repository.impl.WatchListPostRepositoryimpl;
import za.ac.cput.vehicledealership.service.WatchListPostService;


import java.util.Set;

public class WatchListPostServiceImpl implements WatchListPostService {
    private static WatchListPostServiceImpl watchListPostService = null;
    private WatchListPostRepositoryimpl watchListPostRepository = null;

    public WatchListPostServiceImpl() {
        this.watchListPostRepository = WatchListPostRepositoryimpl.getWatchListPostRepository();
    }

    public static WatchListPostServiceImpl getWatchListPostService() {
        if(watchListPostService == null) {
            watchListPostService = new WatchListPostServiceImpl();
        }
        return watchListPostService;
    }


    @Override
    public WatchListPost create(WatchListPost watchListPost) {
        return watchListPostRepository.create(watchListPost);
    }


    @Override
    public WatchListPost read(String watchListPostId) {
        return watchListPostRepository.read(watchListPostId);
    }

    @Override
    public WatchListPost update(WatchListPost watchListPost) {
        return watchListPostRepository.update(watchListPost);
    }


    @Override
    public boolean delete(String watchListPostId) {
        return watchListPostRepository.delete(watchListPostId);
    }

    @Override
    public Set<WatchListPost> getAll() {
        return watchListPostRepository.getAll();
    }
}
