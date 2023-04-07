package za.ac.cput.repository;

/*  IVehicleRepository.java
    Repository Interface for Vehicle Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 7 April 2023
*/

import za.ac.cput.domain.Vehicle;

import java.util.List;

public interface IVehicleRepository extends IRepository<Vehicle, String> {
    List<Vehicle> getAll();
}
