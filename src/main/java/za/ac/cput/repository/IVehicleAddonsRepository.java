package za.ac.cput.repository;

import za.ac.cput.domain.Inventory;
import za.ac.cput.domain.VehicleAddons;

import java.util.Set;

public interface IVehicleAddonsRepository extends IRepository<VehicleAddons,String>{
    Set<VehicleAddons> getAll();
}
