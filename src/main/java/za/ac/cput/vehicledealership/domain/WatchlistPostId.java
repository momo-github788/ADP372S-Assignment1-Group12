package za.ac.cput.vehicledealership.domain;

import java.io.Serializable;
import java.util.Objects;


public class WatchlistPostId implements Serializable {

    private long postId;
    private long userId;

    protected WatchlistPostId() {

    }

    public WatchlistPostId(long postId, long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchlistPostId that = (WatchlistPostId) o;
        return postId == that.postId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, userId);
    }
}