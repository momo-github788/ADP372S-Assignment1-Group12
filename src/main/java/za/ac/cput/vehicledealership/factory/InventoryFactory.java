package za.ac.cput.vehicledealership.factory;

/*
    InventoryFactory.java
    Factory for  Inventory Entity
    Kimpoki serge kalala - 220525137
    07 April 2023
 */

import za.ac.cput.vehicledealership.domain.Inventory;
import za.ac.cput.vehicledealership.domain.InventoryType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.util.Helper;

public class InventoryFactory {
    public static Inventory createInventoryFactory(int quantity, InventoryType inventoryType, Vehicle vehicle) {


      String id = Helper.generateId();
        if(Helper.isNullOrEmpty(quantity) || Helper.isNullOrEmpty(inventoryType) ) {
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


