package com.InstaBlog.security;

import com.InstaBlog.exception.ResourceNotFoundException;
import com.InstaBlog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from DB
        return this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "username", username));
    }
}
