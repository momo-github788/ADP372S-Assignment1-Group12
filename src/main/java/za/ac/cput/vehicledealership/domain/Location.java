package za.ac.cput.vehicledealership.domain;

/*  Location.java
    Entity for the Location
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
@Embeddable
public class Location {
    private int streetNumber;
    private String streetName;
    private String city;
    private int postalCode;
    private String province;

    protected Location() {

    }

    private Location(Builder builder) {
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.province = builder.province;
    }

    public static class Builder {
        private int streetNumber;
        private String streetName;
        private String city;
        private int postalCode;
        private String province;

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder copy(Location location) {
            this.streetNumber = location.streetNumber;
            this.streetName = location.streetName;
            this.city = location.city;
            this.postalCode = location.postalCode;
            this.province = location.province;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}