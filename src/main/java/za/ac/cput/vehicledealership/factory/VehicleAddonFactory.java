package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Addon;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleAddon;
import za.ac.cput.vehicledealership.util.Helper;

public class VehicleAddonFactory {
    public static VehicleAddon createVehicleAddonFactory(int vehicleId, int addonId) {

        if(Helper.isNullOrEmpty(vehicleId) || Helper.isNullOrEmpty(addonId)) {
            return null;
        }
        return new VehicleAddon.Builder()
                .setAddonId(addonId)
                .setVehicleId(vehicleId)
                .build();



    }
}

