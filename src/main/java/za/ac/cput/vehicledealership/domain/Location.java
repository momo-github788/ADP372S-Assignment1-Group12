package za.ac.cput.vehicledealership.domain;

/*  Location.java
    Entity for the Location
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return streetNumber == location.streetNumber && postalCode == location.postalCode && Objects.equals(streetName, location.streetName) && Objects.equals(city, location.city) && Objects.equals(province, location.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetNumber, streetName, city, postalCode, province);
    }

    @Override
    public String toString() {
        return "Location{" +
                "streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", province='" + province + '\'' +
                '}';
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