/*
 * WatchListPost.java
 * This is the entity for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */
package za.ac.cput.domain;

public class WatchListPost {
    private Integer watchListPostId;
    private String postId;
    private String userId;

    private WatchListPost(Builder builder) {
        this.watchListPostId = builder.watchListPostId;
        this.postId = builder.postId;
        this.userId = builder.userId;
    }

    public Integer getWatchListPostId() {
        return watchListPostId;
    }

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }

    public static class Builder {
        private Integer watchListPostId;
        private String postId;
        private String userId;

        public Builder withWatchListPostId(Integer watchListPostId) {
            this.watchListPostId = watchListPostId;
            return this;
        }

        public Builder withPostId(String postId) {
            this.postId = postId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public WatchListPost build() {
            return new WatchListPost(this);
        }
    }
}
