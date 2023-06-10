/*  ICarRepository.java
    Repository Interface for Car Domain
    Author: Alan Chapman (220092362)
    Date: 7 April 2023
*/

package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.Car;

import java.util.Set;

public interface CarRepository extends IRepository<Car, String> {
    Set<Car> getAll();
}
