package za.ac.cput.vehicledealership.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.ERole;
import za.ac.cput.vehicledealership.domain.Role;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.dto.UserLoginDTO;
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


    public User register(RegisterRequest request) {

        if(employeeRepository.existsByEmailAddress(request.getEmailAddress()) && request.getEmailAddress().contains("admin")) {

        }

        if (userRepository.existsByEmailAddress(request.getEmailAddress()) && request.getEmailAddress().equals("user")) {
            return null;
        }

        Role adminRole = roleService.findByName(ERole.ADMIN);
        Role userRole = roleService.findByName(ERole.USER);
        Set<Role> roleSet = new HashSet<>();



        if(user.getEmailAddress().contains("admin")) {
            System.out.println("Adding ADMIN and USER role ");
            roleSet.add(adminRole);
            roleSet.add(userRole);
        } else if(user.getEmailAddress().contains("user")) {
            System.out.println("Adding USER role");
            roleSet.add(userRole);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleSet);
        repository.save(user);

        String token = jwtService.generateToken(user.getEmailAddress(), roleSet);
        System.out.println("sign uo");
        System.out.println(token);
        return user;
    }


    public UserLoginDTO login(LoginRequest request) {

        UserLoginDTO userLoginDTO = null;
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailAddress(), request.getPassword()));
            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

//            if(userDetails.getUsername() == null){
//                throw new IllegalArgumentException("Invalid email or password.");
//            }
            String token = jwtService.generateToken(user.getEmailAddress(), userDetails.getAuthorities().stream().collect(Collectors.toSet()));

            userLoginDTO = new UserLoginDTO(userDetails.getUsername(), token, userDetails.getAuthorities());
        } catch (DisabledException e) {
            throw new UsernameNotFoundException("User account is disabled");
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("Invalid credentials");
        }
        return userLoginDTO;
    }

}
