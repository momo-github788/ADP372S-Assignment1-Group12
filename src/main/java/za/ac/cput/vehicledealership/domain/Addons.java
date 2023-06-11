package za.ac.cput.vehicledealership.domain;
/*  Addons.java
    Entity for addons
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/
import java.time.LocalDateTime;
import java.util.Objects;

public class Addons {
    private String addonId;
    private String name;
    private String description;
    private LocalDateTime datePurchased;
    private AddonType addonType;
    private double price;
    private int periodExpirationMonths;
    private long maximumMileageLimit;

    public Addons() {

    }

    public Addons(Builder builder) {
        this.addonId = builder.addonId;
        this.name = builder.name;
        this.description = builder.description;
        this.datePurchased = builder.datePurchased;
        this.addonType = builder.addonType;
        this.price = builder.price;
        this.periodExpirationMonths = builder.periodExpirationMonths;
        this.maximumMileageLimit = builder.maximumMileageLimit;
    }

    public String getAddonId() {
        return addonId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDatePurchased() {
        return datePurchased;
    }

    public AddonType getAddonType() {
        return addonType;
    }

    public double getPrice() {
        return price;
    }

    public int getPeriodExpirationMonths() {
        return periodExpirationMonths;
    }

    public long getMaximumMileageLimit() {
        return maximumMileageLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Addons addons)) return false;
        return Double.compare(addons.getPrice(), getPrice()) == 0 && getPeriodExpirationMonths() == addons.getPeriodExpirationMonths() && getMaximumMileageLimit() == addons.getMaximumMileageLimit() && Objects.equals(getAddonId(), addons.getAddonId()) && Objects.equals(getName(), addons.getName()) && Objects.equals(getDescription(), addons.getDescription()) && Objects.equals(getDatePurchased(), addons.getDatePurchased()) && Objects.equals(getAddonType(), addons.getAddonType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddonId(), getName(), getDescription(), getDatePurchased(), getAddonType(), getPrice(), getPeriodExpirationMonths(), getMaximumMileageLimit());
    }

    @Override
    public String toString() {
        return "Addons{" +
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
        public Addons.Builder copy(Addons adddons) {
            this.addonId = adddons.addonId;
            this.name = adddons.name;
            this.description = adddons.description;
            this.datePurchased = adddons.datePurchased;
            this.addonType = adddons.addonType;
            this.price = adddons.price;
            this.periodExpirationMonths = adddons.periodExpirationMonths;
            this.maximumMileageLimit = adddons.maximumMileageLimit;
            return this;
    }
        public Addons build() {
            return new Addons(this);}
        }
}
