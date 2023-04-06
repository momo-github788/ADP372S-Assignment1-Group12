package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DetailingAddon;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalTime.now;
import static org.junit.jupiter.api.Assertions.*;

class DetailingAddonFactoryTest {
    @Test
    public void test(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = LocalDateTime.now().plusMonths(1);
        System.out.println("Date Checked in " + now);
        DetailingAddon detailingAddon = DetailingAddonFactory.createDetailingAddon(now, then);
        System.out.println();
        assertNotNull(detailingAddon);
    }
}