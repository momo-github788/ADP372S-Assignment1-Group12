package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Inventory;

import java.util.List;


public interface ServiceInventory extends IService <Inventory, String> {
    List<Inventory> getAll();

}