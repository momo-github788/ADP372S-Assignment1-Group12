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
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    protected int vehicleId;
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
    @Column(name = "body_type")
    @Enumerated(EnumType.STRING)
    protected BodyType bodyType;

    @OneToOne
    private Inventory inventory;

    protected Vehicle() {

    }

    protected Vehicle (Builder<?> builder){
        this.vehicleId = builder.vehicleId;
        this.make = builder.make;
        this.model = builder.model;
        this.condition = builder.condition;
        this.fuelType = builder.fuelType;
        this.colour = builder.colour;
        this.year = builder.year;
        this.bodyType = builder.bodyType;
        this.mileage = builder.mileage;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId == vehicle.vehicleId && year == vehicle.year && mileage == vehicle.mileage && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model) && condition == vehicle.condition && fuelType == vehicle.fuelType && Objects.equals(colour, vehicle.colour) && bodyType == vehicle.bodyType && Objects.equals(inventory, vehicle.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, make, model, condition, fuelType, colour, year, mileage, bodyType, inventory);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", condition=" + condition +
                ", fuelType=" + fuelType +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", bodyType=" + bodyType +
                ", inventory=" + inventory +
                '}';
    }

    public static class Builder<T extends Builder<T>> {
        private int vehicleId;
        private String make;
        private String model;
        private VehicleCondition condition;
        private FuelType fuelType;
        private String colour;
        private int year;
        private int mileage;
        private BodyType bodyType;


        public T setVehicleId(int vehicleId) {
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


        public T setBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
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
            this.bodyType = vehicle.bodyType;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}
