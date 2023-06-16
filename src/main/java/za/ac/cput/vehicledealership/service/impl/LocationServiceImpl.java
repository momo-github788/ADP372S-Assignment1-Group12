package za.ac.cput.vehicledealership.service.impl;

/*  LocationServiceImpl.java
    Implementation of LocationService
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Location;
import za.ac.cput.vehicledealership.repository.impl.LocationRepositoryImpl;
import za.ac.cput.vehicledealership.service.LocationService;

import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {

    private static LocationServiceImpl locationService = null;
    private LocationRepositoryImpl locationRepository = null;

    public LocationServiceImpl() {
        this.locationRepository = LocationRepositoryImpl.getLocationRepository();
    }

    public static LocationServiceImpl getLocationService() {
        if(locationService == null) {
            locationService = new LocationServiceImpl();
        }
        return locationService;
    }


    @Override
    public Location create(Location location) {
        return locationRepository.create(location);
    }


    @Override
    public Location read(String locationId) {
        return locationRepository.read(locationId);
    }

    @Override
    public Location update(Location location) {
        return locationRepository.update(location);
    }

    @Override
    public boolean delete(String locationId) {
        return locationRepository.delete(locationId);
    }

    @Override
    public Set<Location> getAll() {
        return locationRepository.getAll();
    }
}
