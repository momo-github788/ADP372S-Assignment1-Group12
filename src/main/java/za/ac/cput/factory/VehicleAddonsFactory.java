package za.ac.cput.factory;

import za.ac.cput.domain.VehicleAddons;

import static za.ac.cput.util.Helper.isNullOrEmpty;

public class VehicleAddonsFactory {
    public static VehicleAddons createVehicleAddonsFactory(String vehicleId, String addonId) {

        if(isNullOrEmpty(vehicleId) || isNullOrEmpty(addonId)) {
            throw new IllegalArgumentException("vehicleId or addonId is empty ");
        }
        return new VehicleAddons.Builder().setAddonId(addonId).setVehicleId(vehicleId).build();



    }
}

