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

@Entity
@Getter
@ToString
@EqualsAndHashCode
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
