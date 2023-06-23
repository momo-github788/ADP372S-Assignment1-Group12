package za.ac.cput.vehicledealership.repository;

/*  IVehicleRepository.java
    Repository Interface for Vehicle Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.vehicledealership.domain.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
