package za.ac.cput.vehicledealership.service.impl;

/*  LocationServiceImpl.java
    Implementation of LocationService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.repository.LocationRepository;
import za.ac.cput.vehicledealership.service.LocationService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository = null;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location read(String locationId) {
        return locationRepository.findById(locationId)
                .orElse(null);
    }

    @Override
    public Location update(Location location) {
        if(this.locationRepository.existsById(location.getLocationId())) {
            return this.locationRepository.save(location);
        }
        return null;
    }

    @Override
    public boolean delete(String locationId) {
        if(this.locationRepository.existsById(locationId)) {
            this.locationRepository.deleteById(locationId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Location> getAll() {
        return locationRepository.findAll().stream().collect(Collectors.toSet());
    }
}
