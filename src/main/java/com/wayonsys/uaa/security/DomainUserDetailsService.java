package com.wayonsys.uaa.security;

import com.wayonsys.account.login.domain.Login;
import com.wayonsys.account.login.repository.LoginRepository;
import com.wayonsys.uaa.domain.User;
import com.wayonsys.uaa.repository.UserRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Authenticate a loginClientAPP from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;
    @Autowired
    private  LoginRepository loginRepository;

    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) {
        log.debug("Authenticating {}", username);

//        if (new EmailValidator().isValid(username, null)) {
//            return userRepository.findOneWithAuthoritiesByEmail(username)
//                .map(user -> createSpringSecurityUser(username, user))
//                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " was not found in the database"));
//        }

//        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
//        return userRepository.findOneWithAuthoritiesByLogin(lowercaseLogin)
//            .map(user -> createSpringSecurityUser(lowercaseLogin, user))
//            .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));

        username.toLowerCase(Locale.ENGLISH);
        return loginRepository.findByUsername(username)
            .map(login -> createSpringSecurityUser(username, login))
            .orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not found in the database"));
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String username, Login login) {
//        if (!login.getActivated()) {
//            throw new UserNotActivatedException("User " + username + " was not activated");
//        }
//        List<GrantedAuthority> grantedAuthorities = login.getAuthorities().stream()
//            .map(authority -> new SimpleGrantedAuthority(authority.getName()))
//            .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(login.getUsername(),
             login.getPassword(),
            null);
    }
}
