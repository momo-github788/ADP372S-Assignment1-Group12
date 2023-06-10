package za.ac.cput.vehicledealership.repository;


import za.ac.cput.vehicledealership.domain.Inventory;

import java.util.Set;

public interface InventoryRepository extends IRepository <Inventory,String> {

    Set<Inventory> getAll();
}
