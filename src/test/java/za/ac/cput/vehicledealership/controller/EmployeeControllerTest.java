package za.ac.cput.vehicledealership.controller;
/* EmployeeControllerTest.java
   Test class for Employee controller class
   Author: George Tapiwa Charimba (220073465)
   Date: 17 August 2023
 */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.vehicledealership.config.TestAuthConfig;
import za.ac.cput.vehicledealership.domain.Branch;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Name;
import za.ac.cput.vehicledealership.factory.EmployeeFactory;
import za.ac.cput.vehicledealership.factory.NameFactory;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private TestAuthConfig authConfig = new TestAuthConfig();


    private static Name name = NameFactory.createName("Mary", "", "Anne");
    private static Employee employee = EmployeeFactory.createEmployee(name, "mary@gmail.com", "P@ssword123");
    private final String AUTH_URL = "http://localhost:8080/auth";

    private final String BASE_URL = "http://localhost:8080/employee";
    private RestTemplate restTemplate = new RestTemplate();

    private static int employeeNumber;

    private HttpEntity<?> performPostRequest(Object object) {
        // This is an employee logged in
        return new HttpEntity<>(object, authConfig.getAuthForEmployee());
    }



    @BeforeEach
    void setUp() {
        if(!employeeRepository.existsByEmailAddress(TestAuthConfig.EMPLOYEE_NAME)) {
            authConfig.registerEmployee(new RegisterRequest(NameFactory.createName("John", "", "Doe"), TestAuthConfig.EMPLOYEE_NAME, TestAuthConfig.PASSWORD));

        }
    }


    @Test
    @Order(1)
    void create() {
        HttpEntity<?> employeeEntity = performPostRequest(employee);

        String url = AUTH_URL + "/employee/register";
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(url, employeeEntity, Employee.class);
        assertNotNull(postResponse);
        System.out.println(postResponse);
        assertNotNull(postResponse.getBody());

        Employee savedEmployee = postResponse.getBody();

        System.out.println("Saved data: " + savedEmployee);
        assertNotNull(savedEmployee);

        employeeNumber = savedEmployee.getEmployeeNumber();
    }

    @Test
    @Order(2)
    void read() throws URISyntaxException {
        String url = BASE_URL + "/read/" + employeeNumber + "?type=employee";
        System.out.println("URL: " + url);
        ResponseEntity<Employee> getResponse = restTemplate
                .exchange(RequestEntity.get(new URI(url))
                        .headers(authConfig.getAuthForEmployee())
                        .build(), Employee.class);

        Employee readEmployee = getResponse.getBody();
        assertEquals(employeeNumber, readEmployee.getEmployeeNumber());

        System.out.println("Read: " + readEmployee);


    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update?type=employee";

        Name middleName = NameFactory.createName("Julian");

        Employee updateEmployee = new Employee.Builder()
                .copy(employee)
                .setName(middleName)
                .build();

        updateEmployee.setEmployeeNumber(employeeNumber);

        HttpEntity<?> employeeEntity = performPostRequest(updateEmployee);

        System.out.println("URL: " + url);
        System.out.println("POST data: " + updateEmployee);
        ResponseEntity<Employee> response = restTemplate.postForEntity(url, employeeEntity, Employee.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete() {
        authConfig.getAuthForEmployee();
        String url = BASE_URL + "/delete/" + employeeNumber + "?type=employee";
        System.out.println("URL: " + url);

        HttpEntity<?> employeeEntity = performPostRequest(employee);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, employeeEntity, String.class);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // 204 No Content for successful deletion

    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/all?type=employee";
        HttpHeaders headers = new HttpHeaders();
        headers.addAll(authConfig.getAuthForEmployee());
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }


}