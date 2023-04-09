/*  MotorcycleRepositoryImpl.java
    Implementation of IMotorcycleRepository
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Motorcycle;

import java.util.HashSet;
import java.util.Set;

public class MotorcycleRepositoryImpl implements IMotorcycleRepository {
    private static MotorcycleRepositoryImpl motorcycleRepository = null;
    private Set<Motorcycle> motorcycleDB = null;

    private MotorcycleRepositoryImpl() { motorcycleDB = new HashSet<Motorcycle>();}

    public static MotorcycleRepositoryImpl getRepository() {
        if( motorcycleRepository == null) {
            motorcycleRepository = new MotorcycleRepositoryImpl();
        }
        return motorcycleRepository;
    }

    @Override
    public Motorcycle create(Motorcycle motorcycle) {
        boolean success = motorcycleDB.add(motorcycle);
        if(!success) {
            return null;
        }
        return motorcycle;
    }

    @Override
    public Motorcycle read(String vehicleId) {
        Motorcycle motorcycle = motorcycleDB.stream()
                .filter(m -> m.getVehicleId().equals(vehicleId))
                .findAny()
                .orElse(null);
        return motorcycle;
    }

    @Override
    public Motorcycle update(Motorcycle motorcycle) {
        Motorcycle oldMotorcycle = read(motorcycle.getVehicleId());
        if(oldMotorcycle != null) {
            motorcycleDB.remove(oldMotorcycle);
            motorcycleDB.add(motorcycle);
            return motorcycle;
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        Motorcycle motorcycleToDelete = read(vehicleId);
        if (motorcycleToDelete == null) {
            return false;
        }
        motorcycleDB.remove(motorcycleToDelete);
        return true;
    }

    @Override
    public Set<Motorcycle> getAll() { return motorcycleDB;}
}
