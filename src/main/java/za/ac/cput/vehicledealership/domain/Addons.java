package za.ac.cput.vehicledealership.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/*  Addons.java
    Entity for the Addons
    Author: George Tapiwa Charimba (220073465)
    Date: 2 April 2023
*/
public class Addons {
    private String addonId;
    private String name;
    private String description;
    private LocalDateTime date;
    private Vehicle vehicle;
    private double price;
    protected int periodExpirationMonths;

    protected Addons(){

    }

    protected Addons (AddonsBuilder<?> builder) {
        this.addonId = builder.addonId;
        this.name = builder.name;
        this.description = builder.description;
        this.date = builder.date;
        this.vehicle = builder.vehicle;
        this.price = builder.price;
        this.periodExpirationMonths = periodExpirationMonths;
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

    public LocalDateTime getDate() {
        return date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }

    public int getPeriodExpirationMonths() {
        return periodExpirationMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addons addons = (Addons) o;
        return Double.compare(addons.price, price) == 0 && periodExpirationMonths == addons.periodExpirationMonths && Objects.equals(addonId, addons.addonId) && Objects.equals(name, addons.name) && Objects.equals(description, addons.description) && Objects.equals(date, addons.date) && Objects.equals(vehicle, addons.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonId, name, description, date, vehicle, price, periodExpirationMonths);
    }

    @Override
    public String toString() {
        return "Addons{" +
                "addonId='" + addonId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", vehicle=" + vehicle +
                ", price=" + price +
                ", periodExpirationMonths=" + periodExpirationMonths +
                '}';
    }

    public static class AddonsBuilder<T extends AddonsBuilder<T>>{
        private String addonId;
        private String name;
        private String description;
        private LocalDateTime date;
        private Vehicle vehicle;
        private double price;
        private int periodExpirationMonths;

        public T setAddonId(String addonId) {
            this.addonId = addonId;
            return (T) this;
        }

        public T setName(String name) {
            this.name = name;
            return (T) this;
        }

        public T setDescription(String description) {
            this.description = description;
            return (T) this;
        }

        public T setDate(LocalDateTime date) {
            this.date = date;
            return (T) this;
        }

        public T setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return (T) this;
        }

        public T setPrice(double price) {
            this.price = price;
            return (T) this;
        }

        public T setPeriodExpirationMonths(int periodExpirationMonths) {
            this.periodExpirationMonths = periodExpirationMonths;
            return (T) this;
        }

        public AddonsBuilder<?> copy(Addons addons) {
            this.addonId = addons.addonId;
            this.name = addons.name;
            this.description = addons.description;
            this.date = addons.date;
            this.vehicle = addons.vehicle;
            this.price = addons.price;
            this.periodExpirationMonths = addons.periodExpirationMonths;
            return this;
        }

        public Addons build() {return new Addons(this);}
    }
}
