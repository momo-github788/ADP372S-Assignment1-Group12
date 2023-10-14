package za.ac.cput.vehicledealership.factory;

/*
    InventoryFactory.java
    Factory for  Inventory Entity
    Kimpoki serge kalala - 220525137
    07 April 2023
 */

import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Inventory;
import za.ac.cput.vehicledealership.domain.InventoryType;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.util.Helper;

public class InventoryFactory {
    public static Inventory createInventoryFactory(String name, int quantity, InventoryType inventoryType, Branch branch) {
        if(Helper.isNullOrEmpty(quantity) || Helper.isNullOrEmpty(inventoryType) ) {
            throw new IllegalArgumentException("quantity or inventoryType is empty ");
        }
         return new Inventory.Builder()
                 .setName(name)
                 .setQuantity(quantity)
                 .setInventoryType(inventoryType)
                 .setBranch(branch).build();
    }
//    public static Inventory updateInventoryFactorywithid(int id,int quantity, InventoryType inventoryType, Vehicle vehicle) {
//        if(Helper.isNullOrEmpty(quantity) || Helper.isNullOrEmpty(inventoryType) ) {
//            throw new IllegalArgumentException("quantity or inventoryType is empty ");
//        }
//        return new Inventory.Builder().setInventoryId(id).setQuantity(quantity) .setInventoryType(inventoryType) .setVehicle(vehicle).build();
//    }
}


