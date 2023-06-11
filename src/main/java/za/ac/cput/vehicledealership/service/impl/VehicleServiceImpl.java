package za.ac.cput.vehicledealership.service.impl;

/*  VehicleServiceImpl.java
    Service Interface for Location Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

/*  VehicleServiceImpl.java
    Implementation of VehicleService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.repository.impl.VehicleRepositoryImpl;
import za.ac.cput.vehicledealership.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private static VehicleServiceImpl vehicleService = null;
    private VehicleRepositoryImpl vehicleRepository = null;

    public VehicleServiceImpl() {
        this.vehicleRepository = VehicleRepositoryImpl.getVehicleRepository();
    }

    public static VehicleServiceImpl getVehicleService() {
        if(vehicleService == null) {
            vehicleService = new VehicleServiceImpl();
        }
        return vehicleService;
    }


    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.create(vehicle);
    }


    @Override
    public Vehicle read(String vehicleId) {
        return vehicleRepository.read(vehicleId);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepository.update(vehicle);
    }


    @Override
    public boolean delete(String vehicleId) {
        return vehicleRepository.delete(vehicleId);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.getAll();
    }
}
