package za.ac.cput.vehicledealership.repository;

/*  ILocationRepository.java
    Repository Interface for Location Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import za.ac.cput.vehicledealership.domain.Location;

import java.util.Set;

public interface LocationRepository extends IRepository<Location, String>  {

    Set<Location> getAll();
}
