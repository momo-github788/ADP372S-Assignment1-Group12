/*  CarServiceImpl.java
    Implementation of CarService
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.repository.impl.CarRepositoryImpl;
import za.ac.cput.vehicledealership.service.CarService;

import java.util.Set;

@Service
public class CarServiceImpl implements CarService {
    private static CarServiceImpl carService = null;
    private CarRepositoryImpl carRepository = null;

    public CarServiceImpl() { this.carRepository = CarRepositoryImpl.getRepository();}

    public static CarServiceImpl getCarService() {
        if(carService == null) {
            carService = new CarServiceImpl();
        }
        return carService;
    }


    @Override
    public Car create(Car car) {
        return carRepository.create(car);
    }


    @Override
    public Car read(String vehicleId) { return carRepository.read(vehicleId);}

    @Override
    public Car update(Car car) {
        return carRepository.update(car);
    }

    @Override
    public boolean delete(String vehicleId) {
        return carRepository.delete(vehicleId);
    }

    @Override
    public Set<Car> getAll() {
        return carRepository.getAll();
    }
}
