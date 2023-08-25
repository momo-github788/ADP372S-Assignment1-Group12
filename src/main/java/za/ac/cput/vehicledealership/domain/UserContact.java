package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import za.ac.cput.vehicledealership.domain.UserContactId;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "user_contact")
@IdClass(UserContactId.class)
public class UserContact {
    @Id
    private String userId;
    @Id
    private String contactId;

    public UserContact() {
    }

    public UserContact(Builder builder) {
        this.userId = builder.userId;
        this.contactId = builder.contactId;
    }


    public static class Builder {
        private String userId;
        private String contactId;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder copy(UserContact userContact) {
            this.userId = userContact.userId;
            this.contactId = userContact.contactId;
            return this;
        }

        public UserContact build() {
            return new UserContact(this);
        }
    }
}