package za.ac.cput.vehicledealership.factory;


/*  VehicleFactory.java
    Factory for the Vehicle Entity
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 3 April 2023
*/


import za.ac.cput.vehicledealership.domain.BodyType;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.util.Helper;

public class VehicleFactory {


    public static Vehicle createVehicle(String make, String model, VehicleCondition condition, FuelType fuelType, BodyType bodyType, String colour, int year, int mileage) {
        if(Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(condition) || Helper.isNullOrEmpty(fuelType) || Helper.isNullOrEmpty(colour)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(mileage) || Helper.isNullOrEmpty(bodyType)) {
            return null;
        }

        if(String.valueOf(year).length() < 4) {
            throw new IllegalArgumentException("Year must be minimum of 4 digits");
        }

        return new Vehicle.Builder()
                .setMake(make)
                .setModel(model)
                .setCondition(condition)
                .setFuelType(fuelType)
                .setColour(colour)
                .setYear(year)
                .setBodyType(bodyType)
                .setMileage(mileage)
                .build();
    }
}