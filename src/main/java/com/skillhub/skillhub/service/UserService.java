package com.skillhub.skillhub.service;

import com.skillhub.skillhub.dto.UserResponseDTO;
import com.skillhub.skillhub.dto.UserUpdateDTO;
import com.skillhub.skillhub.model.User;
import com.skillhub.skillhub.repository.UserRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO getCurrentProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName(); // el username es el correo

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getEmail());
    }

    public Optional<UserResponseDTO> updateUsuario(Long id, UserUpdateDTO dto) {
        return userRepository.findById(id).map(user -> {
            user.setName(dto.getName());
            user.setLastName(dto.getLastName());
            User updated = userRepository.save(user);
            return new UserResponseDTO(
                    updated.getId(),
                    updated.getName(),
                    updated.getLastName(),
                    updated.getEmail());
        });
    }
}
