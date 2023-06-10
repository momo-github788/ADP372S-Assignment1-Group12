/*  CarFactory.java
    Factory for Car Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import static za.ac.cput.vehicledealership.util.Helper.generateId;
import static za.ac.cput.vehicledealership.util.Helper.isNullOrEmpty;

public class CarFactory {
    public static Car createCar(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, boolean isHasTowBar) {

        if( isNullOrEmpty(make) || isNullOrEmpty(model) || isNullOrEmpty(condition) || isNullOrEmpty(fuelType) || isNullOrEmpty(colour)
                || isNullOrEmpty(year) || isNullOrEmpty(mileage)|| isNullOrEmpty(isHasTowBar)) {
            return null;
        }


        return new Car.CarBuilder()
                .setVehicleId(generateId())
                .setMake(make)
                .setModel(model)
                .setCondition(condition)
                .setFuelType(fuelType)
                .setColour(colour)
                .setYear(year)
                .setMileage(mileage)
                .setHasTowBar(isHasTowBar)
                .build();
    }
}
