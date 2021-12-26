package com.club1.studentclubmanager.service;

import com.club1.studentclubmanager.model.User;
import com.club1.studentclubmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        // It is asserted that user is not null, if null, it throws an exception in findUserById method.
        User user = userRepository.findUserById(Long.valueOf(id)).get();
        return new CustomUserDetails(user);
    }
}
