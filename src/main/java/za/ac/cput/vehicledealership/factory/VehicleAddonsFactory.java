package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.util.Helper;

public class VehicleAddonsFactory {
    public static VehicleAddons createVehicleAddonsFactory(String vehicleId, String addonId) {

        if(Helper.isNullOrEmpty(vehicleId) || Helper.isNullOrEmpty(addonId)) {
            throw new IllegalArgumentException("vehicleId or addonId is empty ");
        }
        return new VehicleAddons.Builder().setAddonId(addonId).setVehicleId(vehicleId).build();



    }
}

