package za.ac.cput.vehicledealership.domain;
/*  EmployeeContact.java
    Entity for employeeContact
    Author: George Tapiwa Charimba (220073465)
    Date: 18 June 2023
*/
import java.util.Objects;

public class EmployeeContact {
    private long employeeNumber;
    private Contact contact;

    public EmployeeContact() {
    }

    public EmployeeContact(Builder builder) {
        this.employeeNumber = builder.employeeNumber;
        this.contact = builder.contact;
    }

    public long getEmployeeNumber() {
        return employeeNumber;
    }

    public Contact getContact() {
        return contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeContact that)) return false;
        return getEmployeeNumber() == that.getEmployeeNumber() && Objects.equals(getContact(), that.getContact());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeNumber(), getContact());
    }

    @Override
    public String toString() {
        return "EmployeContact{" +
                "employeeNumber=" + employeeNumber +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {
        private long employeeNumber;
        private Contact contact;

        public Builder setEmployeeNumber(long employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public EmployeeContact.Builder copy(EmployeeContact employeeContact) {
            this.employeeNumber = employeeContact.employeeNumber;
            this.contact = employeeContact.contact;
            return this;
        }

        public EmployeeContact build() {
            return new EmployeeContact(this);
        }
    }
}
