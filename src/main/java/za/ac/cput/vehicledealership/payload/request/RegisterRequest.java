package za.ac.cput.vehicledealership.payload.request;

import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import za.ac.cput.vehicledealership.domain.ContactType;
import za.ac.cput.vehicledealership.domain.Name;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RegisterRequest {

    @Embedded
    private Name name;

    @NotBlank(message = "Required")
    private String password;

    @NotBlank(message = "Required")
    @Email()
    private String emailAddress;

}
