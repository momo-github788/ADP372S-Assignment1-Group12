package za.ac.cput.repository;

/*  VehicleRepositoryImpl.java
    Implementation of IVehicleRepository
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import za.ac.cput.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements IVehicleRepository {

    private static VehicleRepositoryImpl vehicleRepository = null;
    private List<Vehicle> vehicleDB = null;

    private VehicleRepositoryImpl() {
        this.vehicleDB = new ArrayList<>();
    }

    public static VehicleRepositoryImpl getVehicleRepository() {
        if(vehicleRepository == null) {
            vehicleRepository = new VehicleRepositoryImpl();
        }
        return vehicleRepository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        boolean success = vehicleDB.add(vehicle);

        if(!success) {
            return null;
        }
        return vehicle;
    }

    @Override
    public Vehicle read(String vehicleId) {
        return vehicleDB
                .stream()
                .filter(vehicle -> vehicle.getVehicleId().equals(vehicleId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        Vehicle oldVehicle = read(vehicle.getVehicleId());

        if(oldVehicle != null) {
            vehicleDB.remove(oldVehicle);
            vehicleDB.add(vehicle);
            return vehicle;

        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        Vehicle vehicle = read(vehicleId);

        if(vehicle == null) {
            return false;
        }

        vehicleDB.remove(vehicle);
        return true;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDB;
    }
}
