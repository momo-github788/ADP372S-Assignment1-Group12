package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static za.ac.cput.util.Helper.generateId;

class UserFactoryTest {
    @Test
    public void test(){
        LocalDate date = LocalDate.of(2001, 03, 15);

        User user = UserFactory.createUser("Micheal", "James", date, "MJ1234", 1231223412L);
        System.out.println(user.toString());
        assertNotNull(user);
    }
}