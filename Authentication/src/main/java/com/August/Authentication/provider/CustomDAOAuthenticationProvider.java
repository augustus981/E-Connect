package com.August.Authentication.provider;


import com.August.Authentication.entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomDAOAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomDAOAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder ){
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
        super.setUserDetailsService(userDetailsService);
        super.setPasswordEncoder(passwordEncoder);
    }

    public Authentication authenticate(Authentication authentication){
        // Check if provided
        String userID = (authentication.getPrincipal() == null) ? "NoneProvided" : authentication.getName();
        UserDetails user = new UserPrincipal();

        // Check exist in DB
        try{
            user = retrieveUser(userID, (UsernamePasswordAuthenticationToken) authentication);
        } catch (UsernameNotFoundException userNameNotFoundExeption){
            logger.debug("User " + userID + " not found");
        }

        Object principalToReturn = user;
        return createSuccessAuthentication(principalToReturn, authentication, user);
    }
}
