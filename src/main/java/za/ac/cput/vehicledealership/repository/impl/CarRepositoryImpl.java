/*  CarRepositoryImpl.java
    Implementation of ICartRepository
    Author: Alan Chapman (220092362)
    Date: 7 April 2023
*/

package za.ac.cput.vehicledealership.repository.impl;

import za.ac.cput.vehicledealership.domain.Car;
import za.ac.cput.vehicledealership.repository.CarRepository;

import java.util.HashSet;
import java.util.Set;

public class CarRepositoryImpl implements CarRepository {
    private static CarRepositoryImpl carRepository = null;
    private Set<Car> carDB = null;

    private CarRepositoryImpl() { carDB = new HashSet<Car>();}

    public static CarRepositoryImpl getRepository() {
        if (carRepository == null) {
            carRepository = new CarRepositoryImpl();
        }
        return carRepository;
    }

    @Override
    public Car create(Car car) {
        boolean success = carDB.add(car);

        if (!success) {
            return null;
        }
        return car;
    }

    @Override
    public Car read(String vehicleId) {
        Car car = carDB.stream()
                .filter (c -> c.getVehicleId().equals(vehicleId))
                .findAny()
                .orElse(null);
        return car;
    }

    @Override
    public Car update( Car car) {
        Car oldCar = read(car.getVehicleId());
        if (oldCar != null) {
            carDB.remove(oldCar);
            carDB.add(car);
            return car;
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        Car carToDelete = read(vehicleId);
        if (carToDelete == null) {
            return false;
        }
        carDB.remove(carToDelete);
        return true;
    }

    @Override
    public Set<Car> getAll() { return carDB;}
}
