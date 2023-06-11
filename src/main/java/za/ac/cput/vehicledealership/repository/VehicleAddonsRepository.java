package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.VehicleAddons;

import java.util.Set;

public interface VehicleAddonsRepository extends IRepository<VehicleAddons,String>{
    Set<VehicleAddons> getAll();
}
