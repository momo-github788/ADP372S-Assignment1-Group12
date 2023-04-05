package za.ac.cput.domain;
/*  User.java
    Entity for the User
    Junaid Cedrass - 219090912
    03 April 2023
 */
import java.time.LocalDate;
import java.util.Objects;


public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private LocalDate dateJoined;
    private String password;
    private Long contact;

    private User() {

    }

    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateJoined = builder.dateJoined;
        this.password = builder.password;
        this.contact = builder.contact;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public String getPassword() {
        return password;
    }

    public Long getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(userId, user.userId) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(dateJoined, user.dateJoined) && Objects.equals(password, user.password) && Objects.equals(contact, user.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, dateJoined, password, contact);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateJoined=" + dateJoined +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class UserBuilder {
        private String userId;
        private String firstName;
        private String lastName;
        private LocalDate dateJoined;
        private String password;
        private Long contact;

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

        public UserBuilder setContact(Long contact) {
            this.contact = contact;
            return this;
        }

        public UserBuilder copy(User user) {
            this.userId = user.userId;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.dateJoined = user.dateJoined;
            this.password = user.password;
            this.contact = user.contact;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}