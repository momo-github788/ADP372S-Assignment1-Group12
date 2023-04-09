package za.ac.cput.factory;
/*  DetaailingAddonsFactoryTest.java
    Test class for DetailingAddonsFactory
    Author: Junaid Cedrass (219090912)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DetailingAddon;
import za.ac.cput.domain.FuelType;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.domain.VehicleCondition;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class DetailingAddonFactoryTest {
    @Test
    public void test(){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = LocalDateTime.now().plusMonths(1);
        LocalDateTime date = LocalDateTime.now();

        Vehicle vehicle = VehicleFactory.createVehicle("Audi", "A4", VehicleCondition.USED, FuelType.PETROL, "White", 2019, 23000);


        DetailingAddon detailingAddon = DetailingAddonFactory.createDetailingAddon("Warranty", "1 year warranty",date,vehicle,1500,12,now, then);
        System.out.println(detailingAddon);
        assertNotNull(detailingAddon);
    }
}