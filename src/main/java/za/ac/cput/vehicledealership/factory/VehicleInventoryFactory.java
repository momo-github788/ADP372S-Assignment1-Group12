

package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.VehicleInventory;
import za.ac.cput.vehicledealership.domain.WatchListPost;

public class VehicleInventoryFactory {
    public static VehicleInventory createVehicleInventory(int vehicleId, int inventoryId) {
        return new VehicleInventory.Builder()
                .setInventoryId(inventoryId)
                .setVehicleId(vehicleId)
                .build();
    }
}

