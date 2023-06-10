package za.ac.cput.vehicledealership.service;

/*  LocationService.java
    Service Interface for Location Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Location;

import java.util.Set;

public interface LocationService extends IService<Location, String> {
    Set<Location> getAll();
}
