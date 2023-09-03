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
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name="watchlist_post")
@IdClass(WatchlistPostId.class)
public class WatchListPost implements Serializable {
    @Id
    @Column(name = "post_id")
    private int postId;
    @Id
    @Column(name = "user_id")
    private int userId;

    protected WatchListPost() {

    }

    private WatchListPost(Builder builder) {
        this.postId = builder.postId;
        this.userId = builder.userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchListPost that = (WatchListPost) o;
        return Objects.equals(postId, that.postId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId);
    }

    @Override
    public String toString() {
        return "WatchListPost{" +
                "postId='" + postId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public static class Builder {
        private int postId;
        private int userId;


        public Builder setPostId(int postId) {
            this.postId = postId;
            return this;
        }

        public Builder setUserId(int userId) {
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

