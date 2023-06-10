/*  MotorcycleFactory.java
    Factory for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.FuelType;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;
import za.ac.cput.vehicledealership.util.Helper;

public class MotorcycleFactory {

    public static Motorcycle createMotorcycle(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, boolean isHasSideCar) {

        if( Helper.isNullOrEmpty(make) || Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(condition) || Helper.isNullOrEmpty(fuelType) || Helper.isNullOrEmpty(colour)
                 || Helper.isNullOrEmpty(year) || Helper.isNullOrEmpty(mileage) || Helper.isNullOrEmpty(isHasSideCar)) {
             return null;
         }

         return new Motorcycle.MotorcycleBuilder()
                 .setVehicleId(Helper.generateId())
                 .setMake(make)
                 .setModel(model)
                 .setCondition(condition)
                 .setFuelType(fuelType)
                 .setColour(colour)
                 .setYear(year)
                 .setMileage(mileage)
                 .setHasSideCar(isHasSideCar)
                 .build();
    }
}
