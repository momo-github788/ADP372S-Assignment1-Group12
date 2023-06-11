package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Car;

import java.util.Set;

public interface CarService extends IService<Car, String>{
    Set<Car> getAll();
}
