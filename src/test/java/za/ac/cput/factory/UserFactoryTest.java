package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {
    @Test
    public void test(){
        LocalDate date = LocalDate.of(2001, 03, 15);
        Contact contact = ContactFactory.createContact("0210434353", "michealjames@gmail.com");

        User user = UserFactory.createUser("Micheal", "James", date, "MJ1234",contact);
        System.out.println(user.toString());
        assertNotNull(user);
    }
}