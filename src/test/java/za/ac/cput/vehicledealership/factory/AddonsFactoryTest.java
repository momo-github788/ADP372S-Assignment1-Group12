package za.ac.cput.vehicledealership.factory;
/*  AddonsFactoryTest.java
    Test class for AddonsFactory
    Author: George Tapiwa Charimba (220073465)
    Date: 3 April 2023
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.*;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddonsFactoryTest {


    @Test
    public void testCreateAddonSuccess(){
        Addons addons = AddonsFactory.createAddons("Sunroof", "Panoramic", LocalDateTime.now(), AddonType.DETAILINGADDON, 1500, 12, 5000);

        System.out.println(addons);
        assertNotNull(addons);
    }
}