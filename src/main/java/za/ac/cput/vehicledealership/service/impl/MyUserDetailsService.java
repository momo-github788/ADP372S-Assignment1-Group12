package za.ac.cput.vehicledealership.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;
import za.ac.cput.vehicledealership.repository.EmployeeRepository;
import za.ac.cput.vehicledealership.repository.UserRepository;
import za.ac.cput.vehicledealership.security.MyUserDetails;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

        User user = userRepository.findByEmailAddress(emailAddress);

        if(user == null) {
            throw new UsernameNotFoundException("Invalid credentials / Account not found");
        }
        return MyUserDetails.createAppUser(user);
    }


}
