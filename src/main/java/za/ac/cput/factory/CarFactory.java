/*  CarFactory.java
    Factory for Car Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Car;

import static za.ac.cput.util.Helper.isNullOrEmpty;

public class CarFactory {
    public static Car createCar(boolean isHasTowBar) {

        if(isNullOrEmpty(isHasTowBar)) {
            return null;
        }

        return new Car.CarBuilder()
                .setHasTowBar(isHasTowBar)
                .build();
    }
}
