package za.ac.cput.vehicledealership.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.security.MyUserDetails;


@Service
@AllArgsConstructor
public class MyEmployeeDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByEmailAddress(emailAddress);
        System.out.println("lookin fo employwe" + emailAddress);
        System.out.println(employee);

        if(employee == null) {
            throw new UsernameNotFoundException("Invalid credentials / Account not found");
        }
        return MyUserDetails.createAppUser(employee);
    }


}
