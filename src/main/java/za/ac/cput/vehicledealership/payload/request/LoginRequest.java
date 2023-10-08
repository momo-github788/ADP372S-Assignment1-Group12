package za.ac.cput.vehicledealership.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Required")
    @Email(message = "Email is invalid")
    private String emailAddress;

    @NotBlank(message = "Required")
    private String password;

}