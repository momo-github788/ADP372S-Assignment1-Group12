package za.ac.cput.vehicledealership.security.jwt;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import za.ac.cput.vehicledealership.domain.ERole;
import za.ac.cput.vehicledealership.service.impl.JwtServiceImpl;
import za.ac.cput.vehicledealership.service.impl.MyEmployeeDetailsService;
import za.ac.cput.vehicledealership.service.impl.MyUserDetailsService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtServiceImpl jwtService;
    private final MyUserDetailsService userDetailsService;
    private final MyEmployeeDetailsService employeeDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String token = jwtService.getToken(request) ;


        System.out.println("token in do filet internal");
        System.out.println(token);
        if (token!=null && jwtService.validateToken(token)) {

            String email = jwtService.extractUserName(token);
            System.out.println("email from token");
            System.out.println(email);

            // get claims
            Claims claims = jwtService.extractAllClaims(token);

            // get list of roles from claims
            List<Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles");

            // check for occurence of an ADMIN role
            boolean isAdmin = roles.stream().anyMatch(e -> e.containsValue(ERole.ADMIN.toString()));


            if (isAdmin) {
                System.out.println("THIS IS AN ADMIN REQUEST");
                UserDetails employeeDetails = employeeDetailsService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(employeeDetails.getUsername() ,null , employeeDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } else {
                System.out.println("THIS IS A USER REQUEST");
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,null , userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }
        filterChain.doFilter(request,response);
    }
}