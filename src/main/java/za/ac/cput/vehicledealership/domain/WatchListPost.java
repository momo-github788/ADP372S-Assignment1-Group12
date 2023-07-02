/*
 * WatchListPost.java
 * This is the entity for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="watchlist_post")
@IdClass(WatchlistPostId.class)
public class WatchListPost implements Serializable {
    @Id
    private String postId;
    @Id
    private String userId;

    protected WatchListPost() {

    }

    private WatchListPost(Builder builder) {
        this.postId = builder.postId;
        this.userId = builder.userId;
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
                ", postId='" + postId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public static class Builder {
        private String postId;
        private String userId;


        public Builder setPostId(String postId) {
            this.postId = postId;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }


        private Builder copy(WatchListPost watchListPost) {
            this.postId = watchListPost.postId;
            this.userId = watchListPost.userId;

            return this;
        }

        public WatchListPost build() {
            return new WatchListPost(this);
        }
    }
}

