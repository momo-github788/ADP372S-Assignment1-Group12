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
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.service.impl.ErrorValidationServiceImpl;
import za.ac.cput.vehicledealership.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final ErrorValidationServiceImpl errorValidationService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User createdUser = userService.register(user);
        if (createdUser == null){
            return ResponseEntity.badRequest().body("User already exists");
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        return ResponseEntity.ok(userService.login(request));
    }


    @PostMapping("/employee/register")
    public ResponseEntity<?> employeeRegister(@RequestBody Employee employee) {
        User createdUser = userService.register(user);
        if (createdUser == null){
            return ResponseEntity.badRequest().body("User already exists");
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/employee/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request, BindingResult result) {

        ResponseEntity<?> errorMap = errorValidationService.validationService(result);
        if(errorMap != null) return errorMap;

        return ResponseEntity.ok(userService.login(request));
    }
}
