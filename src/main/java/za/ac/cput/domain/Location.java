package za.ac.cput.domain;

/*  Location.java
    Entity for the Location
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import java.util.Objects;

public class Location {
    private String locationId;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private String province;

    private Location() {

    }

    private Location(LocationBuilder builder) {
        this.locationId = builder.locationId;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.province = builder.province;
    }


    public String getLocationId() {
        return locationId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return streetNumber == location.streetNumber && Objects.equals(locationId, location.locationId) && Objects.equals(streetName, location.streetName) && Objects.equals(city, location.city) && Objects.equals(postalCode, location.postalCode) && Objects.equals(province, location.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, streetNumber, streetName, city, postalCode, province);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                '}';
    }

    public static class LocationBuilder {
        private String locationId;
        private int streetNumber;
        private String streetName;
        private String city;
        private String postalCode;
        private String province;

        public LocationBuilder setLocationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public LocationBuilder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public LocationBuilder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public LocationBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public LocationBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public LocationBuilder setProvince(String province) {
            this.province = province;
            return this;
        }

        public LocationBuilder copy(Location location) {
            this.locationId = location.locationId;
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