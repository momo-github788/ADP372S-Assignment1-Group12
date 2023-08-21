package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;

import java.time.LocalDateTime;

import static za.ac.cput.vehicledealership.util.Helper.*;

public class EmployeeFactory {

    public static Employee createEmployee(Name name, String password, String emailAddress) {

        if(isNullOrEmpty(password) || isNullOrEmpty(name) || isNullOrEmpty(emailAddress)) {
            return null;
        }

        if(password.length() < 6) {
            throw new RuntimeException("Password must be atleast 6 characters");
        }

        if(!isValidEmail(emailAddress)) {
            throw new RuntimeException("Email format is invalid");

        }

        if(!isValidPassword(password)) {
            throw new RuntimeException("Password must contain atleast one uppercase letter, one lowercase letter and one digit.");
        }

        return new Employee.Builder()
                .setEmployeeNumber(generateId())
                .setName(name)
                .setDateJoined(LocalDateTime.now())
                .setPassword(password)
                .setEmailAddress(emailAddress)
                .build();

    }
}
