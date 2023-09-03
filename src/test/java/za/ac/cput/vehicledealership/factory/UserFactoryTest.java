package za.ac.cput.vehicledealership.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.vehicledealership.domain.ContactDetail;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFactoryTest {
    @Test
    public void test(){
        Name name = NameFactory.createName("Mary", "", "Anne");
        User user = UserFactory.createUser(name, "P@ssword123", "mary@gmail.com");
        System.out.println(user.toString());
        assertNotNull(user);
    }
}