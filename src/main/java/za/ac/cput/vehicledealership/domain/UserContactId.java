package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class UserContactId implements Serializable {

    private long userId;
    private long contactId;

    protected UserContactId() {

    }

}