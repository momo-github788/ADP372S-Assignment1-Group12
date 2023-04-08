package za.ac.cput.repository;


import za.ac.cput.domain.Inventory;

import java.util.Set;

public interface IInventoryRepository extends IRepository <Inventory,String> {

    Set<Inventory> getAll();
}
