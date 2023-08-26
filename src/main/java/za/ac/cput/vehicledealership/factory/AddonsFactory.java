package za.ac.cput.vehicledealership.factory;

/*  AddonsFactory.java
    Factory for the Addons Entity
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/

import za.ac.cput.vehicledealership.domain.AddonType;
import za.ac.cput.vehicledealership.domain.Addon;

import za.ac.cput.vehicledealership.util.Helper;

import java.time.LocalDateTime;

public class AddonsFactory {

    public static Addon createAddons(String name, String description, LocalDateTime datePurchased, AddonType addonType, double price, int periodExpirationMonths, long maximumMileageLimit){
        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(datePurchased) || Helper.isNullOrEmpty(price) || Helper.isNullOrEmpty(periodExpirationMonths) ||
        Helper.isNullOrEmpty(maximumMileageLimit)) {
            return null;
        }

        return new Addon.Builder()
                .setAddonId(Helper.generateId())
                .setName(name)
                .setDescription(description)
                .setDatePurchased(datePurchased)
                .setAddonType(addonType)
                .setPrice(price)
                .setPeriodExpirationMonths(periodExpirationMonths)
                .setMaximumMileageLimit(maximumMileageLimit)
                .build();
    }
}
