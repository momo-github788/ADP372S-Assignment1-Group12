/*  CarFactory.java
    Factory for Car Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.BodyType;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.util.Helper;

import static za.ac.cput.vehicledealership.util.Helper.generateId;
import static za.ac.cput.vehicledealership.util.Helper.isNullOrEmpty;

public class CarFactory {
    public static Car createCar(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, boolean hasTowBar, BodyType bodyType) {

        if(Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(condition) || Helper.isNullOrEmpty(fuelType) || Helper.isNullOrEmpty(colour)
                || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(mileage)|| Helper.isNullOrEmpty(hasTowBar) || Helper.isNullOrEmpty(bodyType)) {
            return null;
        }


        return new Car.CarBuilder()
                .setMake(make)
                .setModel(model)
                .setCondition(condition)
                .setFuelType(fuelType)
                .setColour(colour)
                .setYear(year)
                .setMileage(mileage)
                .setHasTowBar(hasTowBar)
                .setBodyType(bodyType)
                .build();
    }
}
