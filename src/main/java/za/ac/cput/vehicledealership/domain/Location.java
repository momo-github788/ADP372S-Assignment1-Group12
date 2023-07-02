package za.ac.cput.vehicledealership.domain;

/*  Location.java
    Entity for the Location
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Location {
    private int streetNumber;
    private String streetName;
    private City city;
    private String postalCode;
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

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return streetNumber == location.streetNumber && Objects.equals(streetName, location.streetName) && Objects.equals(city, location.city) && Objects.equals(postalCode, location.postalCode) && Objects.equals(province, location.province);
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
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public static class Builder {
        private int streetNumber;
        private String streetName;
        private City city;
        private String postalCode;
        private String province;

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setCity(City city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
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