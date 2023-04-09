package za.ac.cput.factory;
/*
    DetailingAddOnFactory.java
    Factory for DetailingAddonEntity
    Junaid Cedrass - 219090912
    04 April 2023
 */

import za.ac.cput.domain.DetailingAddon;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.Date;

import static za.ac.cput.util.Helper.generateId;

public class DetailingAddonFactory {


    public static DetailingAddon createDetailingAddon(String name, String description, LocalDateTime date, Vehicle vehicle, double price, int periodExpirationMonths, LocalDateTime dateCheckedIn, LocalDateTime dateCheckedOut){
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(date)
                || Helper.isNullOrEmpty(vehicle)
                || Helper.isNullOrEmpty(price)
                || Helper.isNullOrEmpty(periodExpirationMonths)
                || Helper.isNullOrEmpty(dateCheckedIn)
                || Helper.isNullOrEmpty(dateCheckedOut)){
            return null;
        }
        return new DetailingAddon.DetailingAddOnBuilder()
                .setAddonId(generateId())
                .setName(name)
                .setDescription(description)
                .setDate(date)
                .setVehicle(vehicle)
                .setPrice(price)
                .setPeriodExpirationMonths(periodExpirationMonths)
                .setDateCheckedIn(dateCheckedIn)
                .setDateCheckedOut(dateCheckedOut)
                .build();
    }
}
