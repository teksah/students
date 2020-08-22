package com.sda.javagda34.students.service;

import com.sda.javagda34.students.model.User;
import com.sda.javagda34.students.repository.UserRepository;
import com.sda.javagda34.students.security.AppUserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s)  {
        final User user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }

        return new AppUserPrincipal(user);
    }
}
