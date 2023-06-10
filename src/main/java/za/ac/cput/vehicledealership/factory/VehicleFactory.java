package za.ac.cput.vehicledealership.factory;


/*  VehicleFactory.java
    Factory for the Vehicle Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/



import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.util.Helper;
import za.ac.cput.vehicledealership.domain.FuelType;

public class VehicleFactory {

    public static Vehicle createVehicle(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage) {
        if(Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(condition) || Helper.isNullOrEmpty(fuelType) || Helper.isNullOrEmpty(colour)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(mileage)) {
            return null;
        }

        if(String.valueOf(year).length() < 4) {
            throw new IllegalArgumentException("Year must be minimum of 4 digits");
        }

        return new Vehicle.Builder()
                .setVehicleId(Helper.generateId())
                .setMake(make)
                .setModel(model)
                .setCondition(condition)
                .setFuelType(fuelType)
                .setColour(colour)
                .setYear(year)
                .setMileage(mileage)
                .build();
    }
}