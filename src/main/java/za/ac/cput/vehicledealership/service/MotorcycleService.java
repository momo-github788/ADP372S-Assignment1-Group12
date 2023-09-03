/*  MotorcycleService.java
    Service Interface for Motorcycle Domain
    Author: Alan Chapman (220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Motorcycle;

import java.util.List;

public interface MotorcycleService extends IService<Motorcycle, Integer>{
    List<Motorcycle> getAll();
}
