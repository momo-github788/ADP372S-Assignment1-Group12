/*  MotorcycleServiceImpl.java
    Implementation of MotorcycleService
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.repository.MotorcycleRepository;
import za.ac.cput.vehicledealership.service.MotorcycleService;

import java.util.List;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {
    private MotorcycleRepository motorcycleRepository;

    public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepository) { this.motorcycleRepository = motorcycleRepository;}

    @Override
    public Motorcycle create(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }


    @Override
    public Motorcycle read(String vehicleId) {
        return motorcycleRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Motorcycle update(Motorcycle motorcycle) {
        if(motorcycleRepository.existsById(motorcycle.getVehicleId())) {
            return this.motorcycleRepository.save(motorcycle);
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        if(motorcycleRepository.existsById(vehicleId)) {
            this.motorcycleRepository.deleteById(vehicleId);
        }
        return false;
    }

    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.findAll();
    }
}
