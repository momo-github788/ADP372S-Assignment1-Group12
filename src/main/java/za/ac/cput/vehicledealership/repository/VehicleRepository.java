package za.ac.cput.vehicledealership.repository;

/*  IVehicleRepository.java
    Repository Interface for Vehicle Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Post;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.domain.VehicleCondition;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findAllByCondition(VehicleCondition condition);
    List<Vehicle> findAllByVehicleIdIn(List<Integer> vehicleIdList);
}
