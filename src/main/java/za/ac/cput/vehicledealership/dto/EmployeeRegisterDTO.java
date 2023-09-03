package za.ac.cput.vehicledealership.dto;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegisterDTO {
    @Embedded
    private Name name;
    @NotBlank(message = "Required")
    private String password;
    @NotBlank(message = "Required")
    @Email()
    private String emailAddress;


}
