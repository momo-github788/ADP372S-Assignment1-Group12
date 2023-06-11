package za.ac.cput.vehicledealership.service.impl;

import za.ac.cput.vehicledealership.domain.Motorcycle;
import za.ac.cput.vehicledealership.repository.impl.MotorcycleRepositoryImpl;
import za.ac.cput.vehicledealership.service.MotorcycleService;

import java.util.Set;

public class MotorcycleServiceImpl implements MotorcycleService {
    private static MotorcycleServiceImpl motorcycleService = null;
    private MotorcycleRepositoryImpl motorcycleRepository = null;

    public MotorcycleServiceImpl() { this.motorcycleRepository = MotorcycleRepositoryImpl.getRepository();}

    public static MotorcycleServiceImpl getMotorcycleService() {
        if(motorcycleService == null) {
            motorcycleService = new MotorcycleServiceImpl();
        }
        return motorcycleService;
    }

    @Override
    public Motorcycle create(Motorcycle motorcycle) {
        return motorcycleRepository.create(motorcycle);
    }


    @Override
    public Motorcycle read(String vehicleId) { return motorcycleRepository.read(vehicleId);}

    @Override
    public Motorcycle update(Motorcycle motorcycle) {
        return motorcycleRepository.update(motorcycle);
    }

    @Override
    public boolean delete(String locationId) {
        return motorcycleRepository.delete(locationId);
    }

    @Override
    public Set<Motorcycle> getAll() {
        return motorcycleRepository.getAll();
    }
}
