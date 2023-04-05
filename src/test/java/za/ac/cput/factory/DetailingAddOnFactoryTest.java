package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DetailingAddOn;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DetailingAddOnFactoryTest {
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();

        DetailingAddOn detailingAddOn = DetailingAddOnFactory.createDetailingAddOn();
        System.out.println();
        assertNotNull(detailingAddOn);
    }

}