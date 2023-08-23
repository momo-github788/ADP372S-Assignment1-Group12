package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.util.Helper;

public class VehicleAddonsFactory {
    public static VehicleAddons createVehicleAddonsFactory(Vehicle vehicleId, Addons addonId) {

        if(Helper.isNullOrEmpty(vehicleId) || Helper.isNullOrEmpty(addonId)) {
            throw new IllegalArgumentException("vehicleId or addonId is empty ");
        }
        return new VehicleAddons.Builder().setAddons(addonId).setVehicleId(vehicleId).build();



    }
}

