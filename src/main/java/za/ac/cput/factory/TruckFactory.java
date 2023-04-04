package za.ac.cput.factory;

import za.ac.cput.domain.Truck;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class TruckFactory {
    public static Truck createTruck(int numOfWheels, double maxLoadCapacity) {
        if(isNullOrEmpty(numOfWheels) || (isNullOrEmpty(maxLoadCapacity))) {
            return null;
        }

        return new Truck.TruckBuilder()
                .setNumOfWheels(numOfWheels)
                .setMaxLoadCapacity(maxLoadCapacity)
                .build();
    }
}
