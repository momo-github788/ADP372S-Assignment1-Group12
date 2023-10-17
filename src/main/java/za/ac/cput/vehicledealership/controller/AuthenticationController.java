package za.ac.cput.vehicledealership.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.service.impl.AuthenticationService;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final ErrorValidationServiceImpl errorValidationService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        User createdUser = authenticationService.registerUser(request);

        if(createdUser == null) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/employee/register")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody RegisterRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        Employee createdEmployee = authenticationService.registerEmployee(request);

        if(createdEmployee == null) {
            return ResponseEntity.badRequest().body("Employee already exists");
        }

        System.out.println("RegisterDTO");
        System.out.println(createdEmployee);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest request, BindingResult result) {
        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        return ResponseEntity.ok(authenticationService.login(request));
    }


}
