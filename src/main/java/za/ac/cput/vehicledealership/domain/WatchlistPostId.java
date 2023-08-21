package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;


@EqualsAndHashCode
@AllArgsConstructor
public class WatchlistPostId implements Serializable {

    private long postId;
    private long userId;

    protected WatchlistPostId() {

    }

}