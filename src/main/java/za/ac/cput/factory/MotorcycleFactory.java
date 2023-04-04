/*  MotorcycleFactory.java
    Factory for Motorcycle Entity
    Author: Alan Chapman (220092362)
    Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Motorcycle;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class MotorcycleFactory {

    public static Motorcycle createMotorcycle(boolean isHasSideCar) {
         if(isNullOrEmpty(isHasSideCar)) {
             return null;
         }

         return new Motorcycle.MotorcycleBuilder()
                 .setHasSideCar(isHasSideCar)
                 .build();
    }
}
