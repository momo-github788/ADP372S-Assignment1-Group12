package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Motorcycle;

import java.util.Set;

public interface MotorcycleService extends IService<Motorcycle, String>{
    Set<Motorcycle> getAll();
}
