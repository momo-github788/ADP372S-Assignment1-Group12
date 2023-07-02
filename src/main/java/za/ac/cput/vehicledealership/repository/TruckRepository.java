/*  ITruckRepository.java
    Repository Interface for Truck Domain
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/
package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Truck;

import java.util.Set;
@Repository
public interface TruckRepository extends JpaRepository<Truck, String> {

}
