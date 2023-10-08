package za.ac.cput.vehicledealership.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.vehicledealership.domain.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    @NotNull(message = "Required")
    private Name name;

    @NotBlank(message = "Required")
    @Email()
    private String emailAddress;

    @Size(min = 6, message = "Minimum of 6 characters")
    @NotBlank(message = "Required")
    private String password;

}
