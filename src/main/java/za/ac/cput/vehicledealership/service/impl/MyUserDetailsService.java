package za.ac.cput.vehicledealership.service.impl;


import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.security.MyUserDetails;

import java.util.stream.Collectors;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HttpServletRequest request;


    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

        String type = request.getParameter("type");

        System.out.println("LOGIN REQUEST IS FOR A " + type);

        if (type.equalsIgnoreCase("employee")) {
            Employee employee = employeeRepository.findByEmailAddress(emailAddress);

            if (employee == null) {
                throw new UsernameNotFoundException("Invalid credentials / Account not found");
            }

            return MyUserDetails.createAppUser(employee);
        } else if (type.equalsIgnoreCase("user")) {
            User user = userRepository.findByEmailAddress(emailAddress);

            if (user == null) {
                throw new UsernameNotFoundException("Invalid credentials / Account not found");
            }

            return MyUserDetails.createAppUser(user);
        }

        throw new UsernameNotFoundException("Invalid credentials / Account not found");
    }
}




//        return User.builder().password(employee.getPassword())
//                .username(employee.getEmailAddress())
//                .authorities(employee.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList()))
//                .build();

