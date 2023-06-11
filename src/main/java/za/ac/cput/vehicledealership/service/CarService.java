/*  CarService.java
    Service Interface for Car Domain
    Author: Alan Chapman (220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Car;

import java.util.Set;

public interface CarService extends IService<Car, String>{
    Set<Car> getAll();
}
