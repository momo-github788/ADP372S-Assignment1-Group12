package za.ac.cput.repository;

/*  LocationRepositoryImpl.java
    Implementation of ILocationRepository
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import za.ac.cput.domain.Location;

import java.util.HashSet;
import java.util.Set;


public class LocationRepositoryImpl implements ILocationRepository {

    private static LocationRepositoryImpl locationRepository = null;
    private Set<Location> locationDB = null;

    private LocationRepositoryImpl() {
        this.locationDB = new HashSet<Location>();
    }

    public static LocationRepositoryImpl getLocationRepository() {
        if(locationRepository == null) {
            locationRepository = new LocationRepositoryImpl();
        }
        return locationRepository;
    }

    @Override
    public Location create(Location location) {
        boolean success = locationDB.add(location);

        if(!success) {
            return null;
        }
        return location;

    }

    @Override
    public Location read(String locationId) {
        return locationDB
                .stream()
                .filter(location -> location.getLocationId().equals(locationId))
                .findAny()
                .orElse(null);
    }

    @Override
    public Location update(Location location) {

        Location oldLocation = read(location.getLocationId());

        if(oldLocation != null) {
            locationDB.remove(oldLocation);
            locationDB.add(location);
            return location;

        }
        return null;

    }

    @Override
    public boolean delete(String locationId) {
        Location location = read(locationId);

        if(location == null) {
            return false;
        }

        locationDB.remove(location);
        return true;
    }

    @Override
    public Set<Location> getAll() {
        return locationDB;
    }
}
