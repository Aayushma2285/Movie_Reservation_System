package com.texas.MovieReservationSystem.service;

import com.texas.MovieReservationSystem.dao.UserRepo;
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
        System.out.println("Email :: " + username);
        return userRepo.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found."));
    }
}
