/*  ICarRepository.java
    Repository Interface for Car Domain
    Author: Alan Chapman (220092362)
    Date: 7 April 2023
*/

package za.ac.cput.vehicledealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.vehicledealership.domain.Car;

import java.util.Set;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
