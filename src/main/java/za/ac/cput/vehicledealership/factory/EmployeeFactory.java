package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;

import java.time.LocalDateTime;

import static za.ac.cput.vehicledealership.util.Helper.*;

public class EmployeeFactory {

    public static Employee createEmployee(Name name, String password) {

        if(isNullOrEmpty(password) || isNullOrEmpty(name)) {
            return null;
        }

        if(password.length() < 6) {
            throw new RuntimeException("Password must be atleast 6 characters");
        }

        if(!isValidPassword(password)) {
            throw new RuntimeException("Password must contain atleast one uppercase letter, one lowercase letter and one digit.");
        }

        return new Employee.Builder()
                .setEmployeeNumber(generateId())
                .setName(name)
                .setDateJoined(LocalDateTime.now())
                .setPassword(password)
                .build();

    }
}
