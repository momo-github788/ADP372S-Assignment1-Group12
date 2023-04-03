package za.ac.cput.factory;


/*  VehicleFactory.java
    Factory for the Vehicle Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/



import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.domain.VehicleCondition;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class VehicleFactory {

    public static Vehicle createVehicle(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage) {
        if(isNullOrEmpty(make) || isNullOrEmpty(model) || isNullOrEmpty(condition) || isNullOrEmpty(fuelType) || isNullOrEmpty(colour)
                || isNullOrEmpty(year) || isNullOrEmpty(mileage)) {
            return null;
        }

        if(String.valueOf(year).length() < 4) {
            throw new IllegalArgumentException("Year must be minimum of 4 digits");
        }

        return new Vehicle.VehicleBuilder()
                .setVehicleId(generateId())
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
