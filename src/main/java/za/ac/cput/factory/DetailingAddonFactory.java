package za.ac.cput.factory;
/*
    DetailingAddOnFactory.java
    Factory for DetailingAddonEntity
    Junaid Cedrass - 219090912
    04 April 2023
 */

import za.ac.cput.domain.DetailingAddon;

import java.time.LocalDateTime;

public class DetailingAddonFactory {


    public static DetailingAddon createDetailingAddon(LocalDateTime dateCheckedIn, LocalDateTime dateCheckedOut){
        return new DetailingAddon.DetailingAddOnBuilder()
                .setDateCheckedIn(dateCheckedIn)
                .setDateCheckedOut(dateCheckedOut)
                .build();
    }
}
