/*  MotorcycleFactory.java
    Factory for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Motorcycle;
import za.ac.cput.domain.VehicleCondition;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class MotorcycleFactory {

    public static Motorcycle createMotorcycle(String make, String model, VehicleCondition condition, FuelType fuelType, String colour, int year, int mileage, boolean isHasSideCar) {

        if( isNullOrEmpty(make) || isNullOrEmpty(model) || isNullOrEmpty(condition) || isNullOrEmpty(fuelType) || isNullOrEmpty(colour)
                 || isNullOrEmpty(year) || isNullOrEmpty(mileage) || isNullOrEmpty(isHasSideCar)) {
             return null;
         }

         return new Motorcycle.MotorcycleBuilder()
                 .setVehicleId(generateId())
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
