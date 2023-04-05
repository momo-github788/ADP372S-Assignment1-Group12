package za.ac.cput.factory;

/*  AddonsFactory.java
    Factory for the ServiceAddon Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
import za.ac.cput.domain.ServicingAddon;
import za.ac.cput.domain.Vehicle;

import java.time.LocalDateTime;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

public class ServicingAddonFactory {
    public static ServicingAddon createServicingAddon(String name, String description, LocalDateTime date, Vehicle vehicle, double price, int periodExpirationMonths, int serviceCount, int mileageLimit){
        if(isNullOrEmpty(name) || isNullOrEmpty(description) || isNullOrEmpty(date) || isNullOrEmpty(vehicle) || isNullOrEmpty(price) || isNullOrEmpty(periodExpirationMonths) ||isNullOrEmpty(serviceCount) || isNullOrEmpty(mileageLimit)){
            return null;
        }

        return new ServicingAddon.ServicingAddonBuilder()
                .setAddonId(generateId())
                .setName(name)
                .setDescription(description)
                .setDate(date)
                .setVehicle(vehicle)
                .setPrice(price)
                .setPeriodExpirationMonths(periodExpirationMonths)
                .setMileageLimit(mileageLimit)
                .setServiceCount(serviceCount)
                .setMileageLimit(mileageLimit)
                .build();
    }
}
