package za.ac.cput.vehicledealership.domain;
/*  UserContact.java
    Entity for user contact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/

import java.util.Objects;

public class UserContact{
    private String userId;
    private Contact contact;

    private UserContact(){};

    public UserContact(Builder builder) {
        this.userId = builder.userId;
        this.contact = builder.contact;
    }

    public String getUserId() {
        return userId;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserContact that)) return false;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getContact(), that.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getContact());
    }

    @Override
    public String toString() {
        return "UserContact{" +
                "userId='" + userId + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{
        private String userId;
        private Contact contact;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public UserContact.Builder copy(UserContact userContact) {
            this.userId = userContact.userId;
            this.contact = userContact.contact;
            return this;
        }

        public UserContact build(){
            return new UserContact(this);
        }
    }
}
