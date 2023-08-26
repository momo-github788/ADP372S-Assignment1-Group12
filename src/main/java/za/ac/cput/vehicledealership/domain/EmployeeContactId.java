package za.ac.cput.vehicledealership.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
public class EmployeeContactId implements Serializable {

    private String employeeNumber;
    private String contactId;

    protected EmployeeContactId() {

    }

}