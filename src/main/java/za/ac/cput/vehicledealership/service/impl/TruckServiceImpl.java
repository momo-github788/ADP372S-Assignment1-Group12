/*  TruckServiceImpl.java
    Implementation of TruckService
    Author: Alan Chapman(220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Truck;
import za.ac.cput.vehicledealership.repository.TruckRepository;
import za.ac.cput.vehicledealership.service.TruckService;

import java.util.List;

@Service
public class TruckServiceImpl implements TruckService {
    private TruckRepository truckRepository;

    public TruckServiceImpl(TruckRepository truckRepository) { this.truckRepository = truckRepository;}

    @Override
    public Truck create(Truck truck) {
        return truckRepository.save(truck);
    }


    @Override
    public Truck read(Integer vehicleId) {
        return truckRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Truck update(Truck truck) {
        if(truckRepository.existsById(truck.getVehicleId())) {
            return this.truckRepository.save(truck);
        }
        return null;
    }

    @Override
    public boolean delete(Integer vehicleId) {
        if(truckRepository.existsById(vehicleId)) {
            this.truckRepository.deleteById(vehicleId);
            return true;
        }
        return false;
    }

    @Override
    public List<Truck> getAll() {
        return truckRepository.findAll();
    }
}
