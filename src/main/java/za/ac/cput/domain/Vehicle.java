package za.ac.cput.domain;

/*  Vehicle.java
    Entity for the Vehicle
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 2 April 2023
*/

import java.util.Objects;

public class Vehicle {
    private String vehicleId;
    private String make;
    private String model;
    private VehicleCondition condition;
    private FuelType fuelType;
    private String colour;
    private int year;
    private int mileage;

    protected Vehicle() {

    }

    protected Vehicle (VehicleBuilder<?> builder){
        this.vehicleId = builder.vehicleId;
        this.make = builder.make;
        this.model = builder.model;
        this.condition = builder.condition;
        this.fuelType = builder.fuelType;
        this.colour = builder.colour;
        this.year = builder.year;
        this.mileage = builder.mileage;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public VehicleCondition getCondition() {
        return condition;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year && mileage == vehicle.mileage && Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model) && condition == vehicle.condition && fuelType == vehicle.fuelType && Objects.equals(colour, vehicle.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, make, model, condition, fuelType, colour, year, mileage);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", condition=" + condition +
                ", fuelType=" + fuelType +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", mileage=" + mileage + ", ";
    }

    public static class VehicleBuilder<T extends VehicleBuilder<T>>{
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

        public VehicleBuilder<?> copy(Vehicle vehicle){
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
