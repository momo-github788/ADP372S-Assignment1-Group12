package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class WatchlistPostId implements Serializable {

    private long postId;
    private long userId;

}