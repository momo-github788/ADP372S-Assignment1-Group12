package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Inventory;

import java.util.List;


public interface InventoryService extends IService <Inventory, Integer> {
    List<Inventory> getAll();

}