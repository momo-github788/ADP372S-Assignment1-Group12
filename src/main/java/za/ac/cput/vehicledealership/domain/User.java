package za.ac.cput.vehicledealership.domain;
/*  User.java
    Entity for the User
    Junaid Cedrass - 219090912
    04 April 2023
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;



@Entity
@Getter
@EqualsAndHashCode
@ToString
public class User  {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String firstName;
    private String lastName;
    private LocalDate dateJoined;
    private String password;


    protected User() {

    }

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
    }

    public static class UserBuilder {
        private String userId;
        private String firstName;
        private String lastName;
        private LocalDate dateJoined;
        private String password;

        public UserBuilder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setDateJoined(LocalDate dateJoined) {
            this.dateJoined = dateJoined;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder copy(User user) {
            this.userId = user.userId;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.dateJoined = user.dateJoined;
            this.password = user.password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}