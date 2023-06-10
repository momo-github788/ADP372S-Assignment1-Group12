package za.ac.cput.vehicledealership.repository.impl;
/*  InventoryRepository.java
    Repository Interface for  VehicleAddons
    Author: Kimpoki serge Kalala 220525137
    Date: 7 April 2023
*/


import za.ac.cput.vehicledealership.domain.VehicleAddons;
import za.ac.cput.vehicledealership.repository.VehicleAddonsRepository;

import java.util.HashSet;
import java.util.Set;

public class VehicleAddonsRepositoryImpl implements VehicleAddonsRepository {


    private static VehicleAddonsRepositoryImpl vehicleAddonsRepository = null;
    private Set<VehicleAddons> VehicleAddonsDB = null;

    private VehicleAddonsRepositoryImpl() {
        this.VehicleAddonsDB = new HashSet<>();
    }

    public static VehicleAddonsRepositoryImpl getRepository() {
        if(vehicleAddonsRepository == null) {
            vehicleAddonsRepository = new VehicleAddonsRepositoryImpl();
        }
        return vehicleAddonsRepository;
    }
    @Override
    public VehicleAddons create(VehicleAddons vehicleAddons) {
        boolean success = this.VehicleAddonsDB.add(vehicleAddons);

        if(!success) {
            return null;
        }

        return vehicleAddons;
    }

    @Override
    public VehicleAddons read(String id) {
        VehicleAddons read =this.VehicleAddonsDB
                .stream()
                .filter(vehicleAddon -> vehicleAddon.getVehicleId().equals(id))
                .findAny()
                .orElse(null);
        return read;
    }

    @Override
    public VehicleAddons update(VehicleAddons type) {
        VehicleAddons oldInventory = read(type.getAddonId());

        if(oldInventory != null) {
            this.VehicleAddonsDB.remove(oldInventory);
            this.VehicleAddonsDB.add(type);
            return type;

        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        VehicleAddons inventory = read(s);

        if(inventory == null) {
            return false;
        }

        this.VehicleAddonsDB.remove(inventory);
        return true;
    }

    @Override
    public Set<VehicleAddons> getAll() {
        return this.VehicleAddonsDB;
    }
}


