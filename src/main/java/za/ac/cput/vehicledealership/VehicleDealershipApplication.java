package za.ac.cput.vehicledealership;

import com.sun.tools.javac.Main;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;

@SpringBootApplication
public class VehicleDealershipApplication {

    @Bean
    public ErrorValidationServiceImpl errorValidationService() {
        return new ErrorValidationServiceImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(VehicleDealershipApplication.class, args);
    }
}
