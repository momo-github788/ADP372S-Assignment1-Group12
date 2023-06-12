/*  MotorcycleService.java
    Service Interface for Motorcycle Domain
    Author: Alan Chapman (220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Motorcycle;

import java.util.Set;

public interface MotorcycleService extends IService<Motorcycle, String>{
    Set<Motorcycle> getAll();
}
