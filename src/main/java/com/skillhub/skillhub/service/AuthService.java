package com.skillhub.skillhub.service;

import com.skillhub.skillhub.dto.LoginRequest;
import com.skillhub.skillhub.dto.LoginResponse;
import com.skillhub.skillhub.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContraseña())
        );

        User user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(token);
    }
}

