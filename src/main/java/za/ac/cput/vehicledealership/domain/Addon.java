package za.ac.cput.vehicledealership.domain;
/*  Addons.java
    Entity for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter

public class Addon {
    @Id
    @Column(name = "addon_id")
    private String addonId;
    private String name;
    private String description;
    private LocalDateTime datePurchased;
    @Enumerated(EnumType.STRING)
    private AddonType addonType;
    private double price;
    private int periodExpirationMonths;
    private long maximumMileageLimit;

    protected Addon() {

    }

    public Addon(Builder builder) {
        this.addonId = builder.addonId;
        this.name = builder.name;
        this.description = builder.description;
        this.datePurchased = builder.datePurchased;
        this.addonType = builder.addonType;
        this.price = builder.price;
        this.periodExpirationMonths = builder.periodExpirationMonths;
        this.maximumMileageLimit = builder.maximumMileageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addon addon = (Addon) o;
        return Double.compare(addon.price, price) == 0 && periodExpirationMonths == addon.periodExpirationMonths && maximumMileageLimit == addon.maximumMileageLimit && Objects.equals(addonId, addon.addonId) && Objects.equals(name, addon.name) && Objects.equals(description, addon.description) && Objects.equals(datePurchased, addon.datePurchased) && addonType == addon.addonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonId, name, description, datePurchased, addonType, price, periodExpirationMonths, maximumMileageLimit);
    }

    @Override
    public String toString() {
        return "Addon{" +
                "addonId='" + addonId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", datePurchased=" + datePurchased +
                ", addonType=" + addonType +
                ", price=" + price +
                ", periodExpirationMonths=" + periodExpirationMonths +
                ", maximumMileageLimit=" + maximumMileageLimit +
                '}';
    }

    public static class Builder {
        private String addonId;
        private String name;
        private String description;
        private LocalDateTime datePurchased;
        private AddonType addonType;
        private double price;
        private int periodExpirationMonths;
        private long maximumMileageLimit;

        public Builder setAddonId(String addonId) {
            this.addonId = addonId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDatePurchased(LocalDateTime datePurchased) {
            this.datePurchased = datePurchased;
            return this;
        }

        public Builder setAddonType(AddonType addonType) {
            this.addonType = addonType;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setPeriodExpirationMonths(int periodExpirationMonths) {
            this.periodExpirationMonths = periodExpirationMonths;
            return this;
        }

        public Builder setMaximumMileageLimit(long maximumMileageLimit) {
            this.maximumMileageLimit = maximumMileageLimit;
            return this;
        }
        public Addon.Builder copy(Addon addon) {
            this.addonId = addon.addonId;
            this.name = addon.name;
            this.description = addon.description;
            this.datePurchased = addon.datePurchased;
            this.addonType = addon.addonType;
            this.price = addon.price;
            this.periodExpirationMonths = addon.periodExpirationMonths;
            this.maximumMileageLimit = addon.maximumMileageLimit;
            return this;
    }
        public Addon build() {
            return new Addon(this);}
        }
}
