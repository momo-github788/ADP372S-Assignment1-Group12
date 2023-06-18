/*  TruckServiceImpl.java
    Implementation of TruckService
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.repository.impl.TruckRepositoryImpl;
import za.ac.cput.vehicledealership.service.TruckService;

import java.util.Set;

@Service
public class TruckServiceImpl implements TruckService {
    private static TruckServiceImpl truckService = null;
    private TruckRepositoryImpl truckRepository = null;

    public TruckServiceImpl() { this.truckRepository = TruckRepositoryImpl.getRepository();}

    public static TruckServiceImpl getTruckService() {
        if(truckService == null) {
            truckService = new TruckServiceImpl();
        }
        return truckService;
    }


    @Override
    public Truck create(Truck truck) {
        return truckRepository.create(truck);
    }


    @Override
    public Truck read(String vehicleId) { return truckRepository.read(vehicleId);}

    @Override
    public Truck update(Truck truck) {
        return truckRepository.update(truck);
    }

    @Override
    public boolean delete(String vehicleId) {
        return truckRepository.delete(vehicleId);
    }

    @Override
    public Set<Truck> getAll() {
        return truckRepository.getAll();
    }
}
