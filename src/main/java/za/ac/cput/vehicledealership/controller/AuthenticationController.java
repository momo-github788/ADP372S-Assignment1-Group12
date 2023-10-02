package za.ac.cput.vehicledealership.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.impl.AuthenticationService;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final ErrorValidationServiceImpl errorValidationService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        RegisterDTO createdUser = authenticationService.registerUser(request);

        if(createdUser == null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/employee/register")
    public ResponseEntity<?> registerEmployee(@RequestBody RegisterRequest request) {
        RegisterDTO createdEmployee = authenticationService.registerEmployee(request);

        if(createdEmployee == null) {
            return ResponseEntity.badRequest().body("Employee already exists");
        }


        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        return ResponseEntity.ok(authenticationService.login(request));
    }

}
