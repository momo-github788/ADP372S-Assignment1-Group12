/*  ITruckRepository.java
    Repository Interface for Truck Domain
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/
package za.ac.cput.vehicledealership.repository;

import za.ac.cput.vehicledealership.domain.Truck;

import java.util.Set;

public interface TruckRepository extends IRepository<Truck, String>{
    Set<Truck> getAll();
}
