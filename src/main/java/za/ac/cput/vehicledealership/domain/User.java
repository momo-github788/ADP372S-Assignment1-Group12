package za.ac.cput.vehicledealership.domain;
/*  User.java
    Entity for the User
    Junaid Cedrass - 219090912
    04 April 2023
 */
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Getter
@Setter
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Embedded
    private Name name;

    private LocalDate dateJoined;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ContactDetail> contactDetails = new HashSet<>();

    private String emailAddress;


    public User() {

    }

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
        this.emailAddress = builder.emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(name, user.name) && Objects.equals(dateJoined, user.dateJoined) && Objects.equals(password, user.password) && Objects.equals(contactDetails, user.contactDetails) && Objects.equals(emailAddress, user.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, dateJoined, password, contactDetails, emailAddress);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name=" + name +
                ", dateJoined=" + dateJoined +
                ", password='" + password + '\'' +
                ", contactDetails=" + contactDetails +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class UserBuilder {
        private int userId;
        private Name name;
        private LocalDate dateJoined;
        private String password;
        private String emailAddress;

        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setName(Name name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
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
            this.name = user.name;
            this.dateJoined = user.dateJoined;
            this.password = user.password;
            this.emailAddress = user.emailAddress;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}