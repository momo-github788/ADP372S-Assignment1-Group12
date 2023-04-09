/*  TruckRepositoryImpl.java
    Implementation of ITruckRepository
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Truck;

import java.util.HashSet;
import java.util.Set;

public class TruckRepositoryImpl implements ITruckRepository {
    private static TruckRepositoryImpl truckRepository = null;
    private Set<Truck> truckDB = null;

    private TruckRepositoryImpl() { truckDB = new HashSet<Truck>();}

    public static TruckRepositoryImpl getRepository() {
        if (truckRepository == null) {
            truckRepository = new TruckRepositoryImpl();
        }
        return truckRepository;
    }

    @Override
    public Truck create(Truck truck) {
        boolean success = truckDB.add(truck);

        if (!success) {
            return null;
        }
        return truck;
    }

    @Override
    public Truck read(String vehicleId) {
        Truck truck = truckDB.stream()
                .filter (c -> c.getVehicleId().equals(vehicleId))
                .findAny()
                .orElse(null);
        return truck;
    }

    @Override
    public Truck update( Truck truck) {
        Truck oldTruck = read(truck.getVehicleId());
        if (oldTruck != null) {
            truckDB.remove(oldTruck);
            truckDB.add(truck);
            return truck;
        }
        return null;
    }

    @Override
    public boolean delete(String vehicleId) {
        Truck truckToDelete = read(vehicleId);
        if (truckToDelete == null) {
            return false;
        }
        truckDB.remove(truckToDelete);
        return true;
    }

    @Override
    public Set<Truck> getAll() { return truckDB;}
}
