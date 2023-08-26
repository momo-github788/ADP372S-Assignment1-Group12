/*
 * WatchListPost.java
 * This is the entity for WatchListPost
 * Author: Simphiwe kahlana(220162891)
 * Date : March 2023
 * */
package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="watchlist_post")
@IdClass(WatchlistPostId.class)
public class WatchListPost implements Serializable {
    @Id
    @Column(name = "post_id")
    private String postId;
    @Id
    @Column(name = "user_id")
    private String userId;

    protected WatchListPost() {

    }

    private WatchListPost(Builder builder) {
        this.postId = builder.postId;
        this.userId = builder.userId;
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

