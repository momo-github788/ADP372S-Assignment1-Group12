/*  CarServiceImpl.java
    Implementation of CarService
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.repository.CarRepository;
import za.ac.cput.vehicledealership.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository = null;

    public CarServiceImpl(CarRepository carRepository) { this.carRepository = carRepository;}

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car read(String vehicleId) {
        return carRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Car update(Car car) {
        if(carRepository.existsById(car.getVehicleId())) {
            return this.carRepository.save(car);
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        if(carRepository.existsById(vehicleId)) {
             this.carRepository.deleteById(vehicleId);
        }
        return false;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
