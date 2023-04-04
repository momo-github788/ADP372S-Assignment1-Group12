/*  TruckFactory.java
    Factory for Truck Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Truck;
import za.ac.cput.domain.VehicleCondition;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class TruckFactory {
    public static Truck createTruck(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, int numOfWheels, double maxLoadCapacity) {

        if( isNullOrEmpty(make) || isNullOrEmpty(model) || isNullOrEmpty(condition) || isNullOrEmpty(fuelType) || isNullOrEmpty(colour)
                || isNullOrEmpty(year) || isNullOrEmpty(mileage) || isNullOrEmpty(numOfWheels) || (isNullOrEmpty(maxLoadCapacity))) {
            return null;
        }

        return new Truck.TruckBuilder()
                .setVehicleId(generateId())
                .setMake(make)
                .setModel(model)
                .setCondition(condition)
                .setFuelType(fuelType)
                .setColour(colour)
                .setYear(year)
                .setMileage(mileage)
                .setNumOfWheels(numOfWheels)
                .setMaxLoadCapacity(maxLoadCapacity)
                .build();
    }
}
