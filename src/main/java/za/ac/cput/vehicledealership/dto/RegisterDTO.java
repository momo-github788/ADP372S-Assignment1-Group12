package za.ac.cput.vehicledealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.ac.cput.vehicledealership.domain.Name;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private Name name;
    private String emailAddress;
    private Collection<?> authorities;
}