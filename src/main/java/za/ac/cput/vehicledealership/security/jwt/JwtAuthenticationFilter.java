package za.ac.cput.vehicledealership.security.jwt;


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
import za.ac.cput.vehicledealership.service.impl.JwtServiceImpl;
import za.ac.cput.vehicledealership.service.impl.MyUserDetailsService;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtServiceImpl jwtService;
    private final MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String token = jwtService.getToken(request) ;

        if (token!=null && jwtService.validateToken(token)) {
            String email = jwtService.extractUserName(token);

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            if (userDetails != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername() ,null , userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        } else {
//            throw new RuntimeException("eeeee invalid");
        }
        filterChain.doFilter(request,response);
    }
}