package za.ac.cput.vehicledealership.service;

/*  VehicleService.java
    Service Interface for Vehicle Domain
    Author: Muhammed Luqmaan Hoosain (220464901)
    Date: 10 June 2023
*/

import za.ac.cput.vehicledealership.domain.Vehicle;

import java.util.List;

public interface VehicleService extends IService<Vehicle, Integer> {
    List<Vehicle> getAll();
}
