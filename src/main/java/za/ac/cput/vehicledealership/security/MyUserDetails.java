package za.ac.cput.vehicledealership.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.vehicledealership.domain.Employee;
import za.ac.cput.vehicledealership.domain.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

        private Employee employee;
        private User user;
        private Collection<? extends GrantedAuthority> authorities;

        public MyUserDetails(User user, Collection<? extends GrantedAuthority> authorities) {
            this.user = user;
            this.authorities = authorities;
        }

        public MyUserDetails(Employee employee, Collection<? extends GrantedAuthority> authorities) {
            this.employee = employee;
            this.authorities = authorities;
        }

        public String getId() {
            if(user != null) {
                return String.valueOf(user.getUserId());
            } else {
                return String.valueOf(employee.getEmployeeNumber());
            }
        }



        public static MyUserDetails createAppUser(User user) {
            List<GrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());

            return new MyUserDetails(user, authorities);
        }

        public static MyUserDetails createAppUser(Employee employee) {
            List<GrantedAuthority> authorities = employee.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());

            return new MyUserDetails(employee, authorities);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            if(user != null) {
                return user.getPassword();
            } else {
                return employee.getPassword();
            }        }

        @Override
        public String getUsername() {
            if(user != null) {
                return user.getEmailAddress();
            } else {
                return employee.getEmailAddress();
            }
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }