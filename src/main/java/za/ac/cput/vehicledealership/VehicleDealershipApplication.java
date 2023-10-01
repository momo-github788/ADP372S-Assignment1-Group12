package za.ac.cput.vehicledealership;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import za.ac.cput.vehicledealership.domain.ERole;
import za.ac.cput.vehicledealership.domain.Role;
import za.ac.cput.vehicledealership.repository.RoleRepository;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

import java.util.ArrayList;

@SpringBootApplication
public class VehicleDealershipApplication {

    @Bean
    public ErrorValidationServiceImpl errorValidationService() {
        return new ErrorValidationServiceImpl();
    }


    public static void main(String[] args) {
        SpringApplication.run(VehicleDealershipApplication.class, args);
    }

    @Bean
    CommandLineRunner run (RoleRepository roleRepository) {
        return  args -> {
            if((roleRepository.findByName(ERole.USER) == null) && roleRepository.findByName(ERole.ADMIN) == null) {
                roleRepository.save(new Role(1L,ERole.USER));
                roleRepository.save(new Role(2L, ERole.ADMIN));
            }




        };}
}
