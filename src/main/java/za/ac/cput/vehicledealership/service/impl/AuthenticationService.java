package za.ac.cput.vehicledealership.service.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ERole;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.Role;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.dto.LoginDTO;
import za.ac.cput.vehicledealership.dto.RegisterDTO;
import za.ac.cput.vehicledealership.payload.request.LoginRequest;
import za.ac.cput.vehicledealership.payload.request.RegisterRequest;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.security.MyUserDetails;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public User registerUser(RegisterRequest request) {

        if(employeeRepository.existsByEmailAddress(request.getEmailAddress()) || userRepository.existsByEmailAddress(request.getEmailAddress())) {
            return null;
        }

        Role userRole = roleService.findByName(ERole.USER);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(userRole);

        User mappedDTOtoUser = modelMapper.map(request, User.class);

        mappedDTOtoUser.setPassword(passwordEncoder.encode(request.getPassword()));
        mappedDTOtoUser.setRoles(roleSet);

        System.out.println("mapped");
        System.out.println(mappedDTOtoUser);

        userRepository.save(mappedDTOtoUser);
        return mappedDTOtoUser;
    }


    public Employee registerEmployee(RegisterRequest request) {

        if(employeeRepository.existsByEmailAddress(request.getEmailAddress()) || userRepository.existsByEmailAddress(request.getEmailAddress())) {
            return null;
        }

        Role adminRole = roleService.findByName(ERole.ADMIN);

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(adminRole);

        Employee mappedDTOtoEmployee = modelMapper.map(request, Employee.class);

        mappedDTOtoEmployee.setPassword(passwordEncoder.encode(request.getPassword()));
        mappedDTOtoEmployee.setRoles(roleSet);

        employeeRepository.save(mappedDTOtoEmployee);
        return mappedDTOtoEmployee;
    }



    public LoginDTO login(LoginRequest request) {

        System.out.println(request);
        LoginDTO loginDTO = null;
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailAddress(), request.getPassword()));
            System.out.println("auth");
            System.out.println(authentication);
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

            String token = jwtService.generateToken(authentication);

            System.out.println("generated token");
            System.out.println(token);

            loginDTO = new LoginDTO(userDetails.getUsername(), token, userDetails.getAuthorities());
        } catch (DisabledException e) {
            throw new UsernameNotFoundException("User account is disabled");
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("Invalid credentials");
        }

        System.out.println(loginDTO);
        return loginDTO;
    }

}
