/*  WatchListRepository.java
    Implementation of IWatchListRepository
    Author: Simphiwe Kahlana (220162891)
    Date: 6 April 2023
*/

package za.ac.cput.repository;


import za.ac.cput.domain.WatchListPost;

import java.util.HashSet;
import java.util.Set;

public class WatchListPostRepositoryimpl implements IWatchListPostRepository {

        private static WatchListPostRepositoryimpl WatchListPostRepositoryimpl = null;
        private Set<WatchListPost> watchListPostDB = null;

        private WatchListPostRepositoryimpl() {
            this.watchListPostDB = new HashSet<WatchListPost>();
        }

        public static WatchListPostRepositoryimpl getWatchListPostRepository() {
            if(WatchListPostRepositoryimpl == null) {
                WatchListPostRepositoryimpl = new WatchListPostRepositoryimpl();
            }
            return WatchListPostRepositoryimpl;
        }

        @Override
        public WatchListPost create(WatchListPost watchListPost) {
            boolean success = watchListPostDB.add(watchListPost);

            if(!success) {
                return null;
            }
            return watchListPost;

        }

        @Override
        public WatchListPost read(String watchListPostId) {
            return watchListPostDB
                    .stream()
                    .filter(location -> location.getWatchListPostId().equals(watchListPostId))
                    .findAny()
                    .orElse(null);
        }

        @Override
        public WatchListPost update(WatchListPost watchListPost) {

            WatchListPost oldWatchListPost = read(watchListPost.getWatchListPostId());

            if(oldWatchListPost != null) {
                watchListPostDB.remove(oldWatchListPost);
                watchListPostDB.add(watchListPost);
                return watchListPost;

            }
            return null;

        }

        @Override
        public boolean delete(String watchListPostId) {
            WatchListPost watchListPost = read(watchListPostId);

            if(watchListPost == null) {
                return false;
            }

            watchListPostDB.remove(watchListPost);
            return true;
        }

        @Override
        public Set<WatchListPost> getAll() {
            return watchListPostDB;
        }
    }




