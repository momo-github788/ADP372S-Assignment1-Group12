package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Embeddable
@Getter
public class Name {

    @NotBlank(message = "Required")
    @Column(name = "first_name")
    @NotBlank(message = "Required")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @NotBlank(message = "Required")
    @Column(name = "last_name")
    private String lastName;

    protected Name() {

    }

    private Name(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(middleName, name.middleName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder {

        private String firstName;
        private String middleName;
        private String lastName;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Name name) {
            this.firstName = name.getFirstName();
            this.middleName = name.getMiddleName();
            this.lastName = name.getLastName();
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }
}
