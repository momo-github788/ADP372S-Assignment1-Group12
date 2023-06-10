/*  TruckFactory.java
    Factory for Truck Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.util.Helper;

public class TruckFactory {
    public static Truck createTruck(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, int numOfWheels, double maxLoadCapacity) {

        if( Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(condition) || Helper.isNullOrEmpty(fuelType) || Helper.isNullOrEmpty(colour)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(mileage) || Helper.isNullOrEmpty(numOfWheels) || (Helper.isNullOrEmpty(maxLoadCapacity))) {
            return null;
        }

        return new Truck.TruckBuilder()
                .setVehicleId(Helper.generateId())
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
