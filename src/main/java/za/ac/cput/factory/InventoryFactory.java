package za.ac.cput.factory;

/*
    InventoryFactory.java
    Factory for  Inventory Entity
    Kimpoki serge kalala - 220525137
    07 April 2023
 */

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

import static za.ac.cput.util.Helper.isNullOrEmpty;

public class InventoryFactory {
    public static Inventory createInventoryFactory(int quantity, String inventoryType, Vehicle vehicle) {
      String id = Helper.generateId();
        if(isNullOrEmpty(quantity) || isNullOrEmpty(inventoryType) ) {
            throw new IllegalArgumentException("quantity or inventoryType is empty ");
        }
        Vehicle vehicle1=VehicleFactory.createVehicle(vehicle.getMake(),
                vehicle.getModel(),vehicle.getCondition(),vehicle.getFuelType(),
                vehicle.getColour(),vehicle.getYear(),vehicle.getMileage());



        return new Inventory.Builder()
                .setInventoryId(id)
                .setQuantity(quantity)
                .setInventoryType(inventoryType)
                .setVehicle(vehicle1).build();
    }




    }


