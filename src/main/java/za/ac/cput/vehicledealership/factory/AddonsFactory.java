package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Addons;
import za.ac.cput.vehicledealership.domain.Vehicle;
import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDateTime;

/*  AddonsFactory.java
    Factory for the Addons Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/
public class AddonsFactory {

    public static Addons createAddons(String name, String description, LocalDateTime date, Vehicle vehicle, double price, int periodExpirationMonths) {

        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(date) || Helper.isNullOrEmpty(vehicle) || Helper.isNullOrEmpty(price) || Helper.isNullOrEmpty(periodExpirationMonths)) {
            return null;
        }

        return new Addons.AddonsBuilder()
                .setAddonId(Helper.generateId())
                .setName(name)
                .setDescription(description)
                .setDate(date)
                .setVehicle(vehicle)
                .setPrice(price)
                .setPeriodExpirationMonths(periodExpirationMonths)
                .build();
    }
}
