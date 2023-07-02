package za.ac.cput.vehicledealership.repository;

/*  ILocationRepository.java
    Repository Interface for Location Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Location;

import java.util.Set;
@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

}
