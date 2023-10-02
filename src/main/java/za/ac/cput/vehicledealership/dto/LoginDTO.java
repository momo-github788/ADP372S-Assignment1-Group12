package za.ac.cput.vehicledealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String emailAddress;
    private String jwt;
    private Collection<?> authorities;
}