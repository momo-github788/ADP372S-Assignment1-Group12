/*  ITruckRepository.java
    Repository Interface for Truck Domain
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Truck;

import java.util.Set;

public interface ITruckRepository extends IRepository<Truck, String>{
    Set<Truck> getAll();
}
