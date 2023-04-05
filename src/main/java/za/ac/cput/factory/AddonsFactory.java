package za.ac.cput.factory;

import za.ac.cput.domain.Addons;
import za.ac.cput.domain.Vehicle;

import java.time.LocalDateTime;

import static za.ac.cput.util.Helper.generateId;
import static za.ac.cput.util.Helper.isNullOrEmpty;

/*  AddonsFactory.java
    Factory for the Addons Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
public class AddonsFactory {

    public static Addons createAddons(String name, String description, LocalDateTime date, Vehicle vehicle, double price, int periodExpirationMonths) {

        if (isNullOrEmpty(name) || isNullOrEmpty(description) || isNullOrEmpty(date) || isNullOrEmpty(vehicle) || isNullOrEmpty(price) || isNullOrEmpty(periodExpirationMonths)) {
            return null;
        }

        return new Addons.AddonsBuilder()
                .setAddonId(generateId())
                .setName(name)
                .setDescription(description)
                .setDate(date)
                .setVehicle(vehicle)
                .setPrice(price)
                .setPeriodExpirationMonths(periodExpirationMonths)
                .build();
    }
}
