package za.ac.cput.vehicledealership.repository.impl;

/*  InventoryRepository.java
    Repository Interface for  Inventory
    Author: Kimpoki serge Kalala 220525137
    Date: 07 April 2023
*/


import za.ac.cput.vehicledealership.domain.Inventory;
import za.ac.cput.vehicledealership.repository.InventoryRepository;

import java.util.HashSet;
import java.util.Set;

public class InventoryRepositoryImpl implements InventoryRepository {


    private static InventoryRepositoryImpl InventoryRepository = null;
    private Set<Inventory> InventoryDB = null;


    private InventoryRepositoryImpl() {
        this.InventoryDB = new HashSet<>();
    }

    public static InventoryRepositoryImpl getRepository() {
        if(InventoryRepository == null) {
            InventoryRepository = new InventoryRepositoryImpl();
        }
        return InventoryRepository;
    }
    @Override
    public Inventory create(Inventory type) {
        boolean success = this.InventoryDB.add(type);

        if(!success) {
            return null;
        }

    return type;
    }

    @Override
    public Inventory read(String s) {
        Inventory read =this.InventoryDB
                .stream()
                .filter(inve -> inve.getInventoryId().equals(s))
                .findAny()
                .orElse(null);
        return read;
    }

    @Override
    public Inventory update(Inventory type) {
        Inventory oldInventory = read(type.getInventoryId());

        if(oldInventory != null) {
            this.InventoryDB.remove(oldInventory);
             this.InventoryDB.add(type);
            return type;

        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Inventory inventory = read(s);

        if(inventory == null) {
            return false;
        }

        this.InventoryDB.remove(inventory);
        return true;
    }

    @Override
    public Set<Inventory> getAll() {
        return this.InventoryDB;
    }
}
