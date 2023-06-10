package za.ac.cput.vehicledealership.factory;

import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;

import java.time.LocalDateTime;

import static za.ac.cput.vehicledealership.util.Helper.generateNumericId;

public class EmployeeFactory {

    public static Employee createEmployee(Name name, String password) {
        return new Employee.Builder()
                .setEmployeeNumber(generateNumericId())
                .setName(name)
                .setDateJoined(LocalDateTime.now())
                .build();
    }
}
