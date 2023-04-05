package za.ac.cput.factory;
/*
    DetailingAddOnFactory.java
    Factory for DetailingAddOnEntity
    Junaid Cedrass - 219090912
    04 April 2023
 */
import za.ac.cput.domain.DetailingAddOn;

public class DetailingAddOnFactory {


    public static DetailingAddOn createDetailingAddOn(){
        return new DetailingAddOn.DetailingAddOnBuilder()
                .setDateCheckedIn(dateCheckedIn)
                .setDateCheckedOut(dateCheckedOut)
                .build();
    }
}
