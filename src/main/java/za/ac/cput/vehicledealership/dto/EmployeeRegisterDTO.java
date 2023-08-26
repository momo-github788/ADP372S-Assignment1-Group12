package za.ac.cput.vehicledealership.dto;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDTO {
    @Embedded
    private Name name;
    private String password;
    private String emailAddress;


}
