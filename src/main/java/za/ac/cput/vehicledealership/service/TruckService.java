/*  TruckService.java
    Service Interface for Truck Domain
    Author: Alan Chapman (220092362)
    Date: 11 June 2023
*/
package za.ac.cput.vehicledealership.service;

import za.ac.cput.vehicledealership.domain.Truck;

import java.util.List;

public interface TruckService extends IService<Truck, String>{
    List<Truck> getAll();
}
