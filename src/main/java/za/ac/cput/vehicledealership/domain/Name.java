package za.ac.cput.vehicledealership.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Embeddable
@Table(name = "name")
public class Name {

    // Reference to Id class
    @EmbeddedId
    private NameId nameId;

    protected Name() {

    }

    private Name(Builder builder) {
        this.nameId = new NameId(builder.firstName, builder.middleName, builder.lastName);
    }

    public NameId getNameId() {
        return nameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(nameId, name.nameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameId);
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
            this.firstName = name.nameId.getFirstName();
            this.middleName = name.nameId.getMiddleName();
            this.lastName = name.nameId.getLastName();
            return this;
        }

        public Name build() {
            return new Name(this);
        }
    }


}
