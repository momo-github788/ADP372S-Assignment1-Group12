package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Truck;

import java.util.Set;

public interface TruckService extends IService<Truck, String>{
    Set<Truck> getAll();
}
