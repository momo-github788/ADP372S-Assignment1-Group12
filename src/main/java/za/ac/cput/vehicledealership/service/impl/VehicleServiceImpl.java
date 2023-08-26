package za.ac.cput.vehicledealership.service.impl;

/*  VehicleServiceImpl.java
    Service Interface for Location Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.factory.VehicleFactory;
import za.ac.cput.vehicledealership.repository.VehicleRepository;
import za.ac.cput.vehicledealership.service.VehicleService;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {


    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }



    @Override
    public Vehicle create(Vehicle vehicle) {
        Vehicle created = VehicleFactory.createVehicle(vehicle.getMake(), vehicle.getModel(), vehicle.getCondition(),
                vehicle.getFuelType(), vehicle.getColour(), vehicle.getYear(), vehicle.getMileage()
        );

        return vehicleRepository.save(created);
    }

    @Override
    public Vehicle read(String vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        if(this.vehicleRepository.existsById(vehicle.getVehicleId())) {
            Vehicle updated = VehicleFactory.createVehicle(vehicle.getMake(), vehicle.getModel(), vehicle.getCondition(),
                    vehicle.getFuelType(), vehicle.getColour(), vehicle.getYear(), vehicle.getMileage()
            );

            return this.vehicleRepository.save(updated);
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        if(this.vehicleRepository.existsById(vehicleId)) {
            this.vehicleRepository.deleteById(vehicleId);
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
