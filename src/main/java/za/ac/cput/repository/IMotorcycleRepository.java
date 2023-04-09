/*  IMotorcycleRepository.java
    Repository Interface for Motorcycle Domain
    Author: Alan Chapman (220092362)
    Date: 9 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Motorcycle;

import java.util.Set;

public interface IMotorcycleRepository extends IRepository<Motorcycle, String>{
    Set<Motorcycle> getAll();
}
