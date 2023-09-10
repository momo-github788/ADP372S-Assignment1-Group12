package za.ac.cput.vehicledealership.domain;

/*  Vehicle.java
    Entity for the Vehicle
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    protected String vehicleId;
    protected String make;
    protected String model;
    @Enumerated(EnumType.STRING)
    @Column(name = "vehicle_condition")
    protected VehicleCondition condition;
    @Enumerated(EnumType.STRING)
    protected FuelType fuelType;
    protected String colour;
    protected int year;
    protected int mileage;

    @OneToOne
    private Inventory inventory;

    public Vehicle() {

    }

    protected Vehicle (Builder<?> builder){
        this.vehicleId = builder.vehicleId;
        this.make = builder.make;
        this.model = builder.model;
        this.condition = builder.condition;
        this.fuelType = builder.fuelType;
        this.colour = builder.colour;
        this.year = builder.year;
        this.mileage = builder.mileage;

    }

    public static class Builder<T extends Builder<T>> {
        private String vehicleId;
        private String make;
        private String model;
        private VehicleCondition condition;
        private FuelType fuelType;
        private String colour;
        private int year;
        private int mileage;


        public T setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return (T) this;
        }

        public T setMake(String make) {
            this.make = make;
            return (T) this;
        }

        public T setModel(String model) {
            this.model = model;
            return (T) this;
        }

        public T setCondition(VehicleCondition condition) {
            this.condition = condition;
            return (T) this;
        }

        public T setFuelType(FuelType fuelType) {
            this.fuelType = fuelType;
            return (T) this;
        }

        public T setColour(String colour) {
            this.colour = colour;
            return (T) this;
        }

        public T setYear(int year) {
            this.year = year;
            return (T) this;
        }

        public T setMileage(int mileage) {
            this.mileage = mileage;
            return (T) this;
        }

        public Builder<?> copy(Vehicle vehicle){
            this.vehicleId = vehicle.vehicleId;
            this.make = vehicle.make;
            this.model = vehicle.model;
            this.condition = vehicle.condition;
            this.fuelType = vehicle.fuelType;
            this.colour = vehicle.colour;
            this.year = vehicle.year;
            this.mileage = vehicle.mileage;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
