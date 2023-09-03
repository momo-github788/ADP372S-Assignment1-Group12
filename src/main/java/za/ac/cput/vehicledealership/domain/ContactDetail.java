package za.ac.cput.vehicledealership.domain;

/*  Contact.java
    Entity for the Contact
    Junaid Cedrass - 219090912
    03 April 2023
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactDetailId;
    @Enumerated(EnumType.STRING)
    @Column(name = "contact_type")
    private ContactType contactType;
    private String value;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_number")
    private Employee employee;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    protected ContactDetail(){

    }
    public ContactDetail(ContactBuilder builder){
        this.contactDetailId = builder.contactDetailId;
        this.contactType = builder.contactType;
        this.value = builder.value;
        this.employee = builder.employee;
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                "contactDetailId=" + contactDetailId +
                ", contactType=" + contactType +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDetail that = (ContactDetail) o;
        return contactDetailId == that.contactDetailId && contactType == that.contactType && Objects.equals(value, that.value) && Objects.equals(employee, that.employee) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactDetailId, contactType, value);
    }



    public static class ContactBuilder {
        private int contactDetailId;
        private ContactType contactType;
        private String value;
        private Employee employee;
        private User user;

        public ContactBuilder setContactDetailId(int contactDetailId) {
            this.contactDetailId = contactDetailId;
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

        public ContactBuilder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public ContactBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public ContactBuilder copy(ContactDetail contact){
            this.contactDetailId = contact.contactDetailId;
            this.contactType = contact.contactType;
            this.value = contact.value;
            this.employee = contact.employee;
            this.user = contact.user;
            return this;
        }

        public ContactDetail build() {
            return new ContactDetail(this);
        }
    }
}