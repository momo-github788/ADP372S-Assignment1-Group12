package za.ac.cput.vehicledealership.domain;
/*  EmployeeContact.java
    Entity for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "employee_contact")
@IdClass(EmployeeContactId.class)
public class EmployeeContact {
    @Id
    @Column(name = "employee_number")
    private String employeeNumber;
    @Id
    @Column(name = "contact_id")
    private String contactId;


    public EmployeeContact() {
    }

    public EmployeeContact(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.contactId = builder.contactId;
    }


    public static class Builder {
        private String employeeNumber;
        private String contactId;

        public Builder setEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setContactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public EmployeeContact.Builder copy(EmployeeContact employeeContact) {
            this.employeeNumber = employeeContact.employeeNumber;
            this.contactId = employeeContact.contactId;
            return this;
        }

        public EmployeeContact build() {
            return new EmployeeContact(this);
        }
    }
}
