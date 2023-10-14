package za.ac.cput.vehicledealership.config;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.dto.LoginDTO;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;

public class TestAuthConfig {

    private final String AUTHENTICATION_URL = "http://localhost:8080/auth";
    private final RestTemplate restTemplate = new RestTemplate();

    public static String USER_NAME = "user@gmail.com";
    public static String EMPLOYEE_NAME = "employee@gmail.com";
    public static String PASSWORD = "password";

    // Creates an employee
    public RegisterDTO registerEmployee(RegisterRequest request) {
        ResponseEntity<RegisterDTO> responseEntity = restTemplate.exchange(
                AUTHENTICATION_URL + "/employee/register",
                HttpMethod.POST,
                new HttpEntity<>(request),
                RegisterDTO.class
        );

        RegisterDTO response = responseEntity.getBody();
        return response;
    }

    // Logs in the employee and returns the token
    private String loginEmployee(LoginRequest request) {
        ResponseEntity<LoginDTO> responseEntity = restTemplate.exchange(
                AUTHENTICATION_URL + "/login?type=employee",
                HttpMethod.POST,
                new HttpEntity<>(request),
                LoginDTO.class
        );

        LoginDTO response = responseEntity.getBody();
        return response.getJwt();
    }


    public RegisterDTO registerUser(RegisterRequest request) {
        ResponseEntity<RegisterDTO> responseEntity = restTemplate.exchange(
                AUTHENTICATION_URL + "/user/register",
                HttpMethod.POST,
                new HttpEntity<>(request),
                RegisterDTO.class
        );

        RegisterDTO response = responseEntity.getBody();
        return response;
    }

    private String loginUser(LoginRequest request) {
        ResponseEntity<LoginDTO> responseEntity = restTemplate.exchange(
                AUTHENTICATION_URL + "/login?type=user",
                HttpMethod.POST,
                new HttpEntity<>(request),
                LoginDTO.class
        );

        LoginDTO response = responseEntity.getBody();
        return response.getJwt();
    }


    // Gets the token of the logged in Employee
    // Sets the token to the HTTP Requests "Authorization Header" , this is how you know the Employee is logged in..
    public HttpHeaders getAuthForEmployee() {
        String token = loginEmployee(new LoginRequest(EMPLOYEE_NAME, PASSWORD));
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    // Gets the token of the logged in user
    // Sets the token to the HTTP Requests "Authorization Header" , this is how you know the user is logged in..
    public HttpHeaders getAuthForUser() {
        String token = loginUser(new LoginRequest(USER_NAME, PASSWORD));
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }



}
