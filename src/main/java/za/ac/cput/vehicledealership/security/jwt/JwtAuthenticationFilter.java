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
import org.slf4j.LoggerFactory;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private JwtServiceImpl jwtService;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private MyEmployeeDetailsService employeeDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        try {

            System.out.println("gettomg reqiest header");
            System.out.println(request.getHeader("Authorization"));
            String jwt = getJwtFromRequest(request);

            if (jwt != null && jwtService.validateToken(jwt)) {
                String username = jwtService.extractUserName(jwt);

                // get claims
                Claims claims = jwtService.extractAllClaims(jwt);

                // get list of roles from claims
                List<Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles");

                // check for occurence of an ADMIN role
                boolean isAdmin = roles.stream().anyMatch(e -> e.containsValue(ERole.ADMIN.toString()));

//                System.out.println("THIS IS A USER REQUEST");
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,null , userDetails.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(authentication);

                if (isAdmin) {
                    System.out.println("THIS IS AN ADMIN REQUEST");
                    UserDetails employeeDetails = employeeDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(employeeDetails.getUsername() ,null , employeeDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                } else {
                    System.out.println("THIS IS A USER REQUEST");
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,null , userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
        }
        filterChain.doFilter(request,response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}