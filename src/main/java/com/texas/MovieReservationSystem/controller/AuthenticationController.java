package com.texas.MovieReservationSystem.controller;

import com.texas.MovieReservationSystem.dto.AuthRequestDto;
import com.texas.MovieReservationSystem.dto.AuthResponseDto;
import com.texas.MovieReservationSystem.jwt.JwtTokenUtil;
import com.texas.MovieReservationSystem.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponseDto response = new AuthResponseDto(accessToken, jwtUtil.EXPIRE_DURATION);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}