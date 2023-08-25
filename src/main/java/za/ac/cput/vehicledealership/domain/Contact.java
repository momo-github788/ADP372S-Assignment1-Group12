package za.ac.cput.vehicledealership.domain;

/*  Contact.java
    Entity for the Contact
    Junaid Cedrass - 219090912
    03 April 2023
 */
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
@Getter
@ToString
@Entity
public class Contact  {
    @Id
    private String contactId;
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;
    private String value;


    protected Contact(){

    }
    public Contact(ContactBuilder builder){
        this.contactId = builder.contactId;
        this.contactType = builder.contactType;
        this.value = builder.value;
    }


    public static class ContactBuilder {
        private String contactId;
        private ContactType contactType;
        private String value;

        public ContactBuilder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public ContactBuilder setContactType(ContactType contactType) {
            this.contactType = contactType;
            return this;
        }

        public ContactBuilder setValue(String value) {
            this.value = value;
            return this;
        }

        public ContactBuilder copy(Contact contact){
            this.contactId = contact.contactId;
            this.contactType = contact.contactType;
            this.value = contact.value;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}