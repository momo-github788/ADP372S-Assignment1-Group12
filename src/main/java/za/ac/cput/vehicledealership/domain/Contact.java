package za.ac.cput.vehicledealership.domain;

/*  Contact.java
    Entity for the Contact
    Junaid Cedrass - 219090912
    03 April 2023
 */
import java.util.Objects;

public class Contact {
    private String contactNumber;
    private String emailAddress;

    private Contact(){

    }
    public Contact(ContactBuilder builder){
        this.contactNumber = builder.contactNumber;
        this.emailAddress = builder.emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact contact)) return false;
        return Objects.equals(contactNumber, contact.contactNumber) && Objects.equals(emailAddress, contact.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactNumber, emailAddress);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
    public static class ContactBuilder {
        private String contactNumber;
        private String emailAddress;

        public ContactBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public ContactBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public ContactBuilder copy(Contact contact){
            this.contactNumber = contact.contactNumber;
            this.emailAddress = contact.emailAddress;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}