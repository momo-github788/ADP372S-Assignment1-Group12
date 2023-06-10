/*
 * WatchListPost.java
 * This is the entity for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */
package za.ac.cput.vehicledealership.domain;

public class WatchListPost {
    private String watchListPostId;
    private String postId;
    private String userId;

    private WatchListPost(Builder builder) {
        this.watchListPostId = builder.watchListPostId;
        this.postId = builder.postId;
        this.userId = builder.userId;
    }


    public String getWatchListPostId() {
        return watchListPostId;
    }

    public void setWatchListPostId(String watchListPostId) {
        this.watchListPostId = watchListPostId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WatchListPost{" +
                "watchListPostId=" + watchListPostId +
                ", postId='" + postId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public static class Builder {
        private String watchListPostId;
        private String postId;
        private String userId;

        public Builder setWatchListPostId(String watchListPostId) {
            this.watchListPostId = watchListPostId;
            return this;
        }

        public Builder setPostId(String postId) {
            this.postId = postId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withWatchListPostId(String watchListPostId) {
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

        private Builder copy(WatchListPost watchListPost) {
            this.watchListPostId = watchListPost.watchListPostId;
            this.postId = watchListPost.postId;
            this.userId = watchListPost.userId;

            return this;
        }

        public WatchListPost build() {
            return new WatchListPost(this);
        }
    }
}

