package za.ac.cput.vehicledealership.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.vehicledealership.domain.Name;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest {

    @NotBlank(message = "Required")
    private Name name;

    @NotBlank(message = "Required")
    @Email()
    private String emailAddress;

    @NotBlank(message = "Required")
    private String password;

}
