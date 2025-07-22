package com.skillhub.skillhub.service;

import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.dto.UsuarioUpdateDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO obtenerPerfilActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String correo = authentication.getName(); // el username es el correo

        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo());
    }

    public Optional<UsuarioResponseDTO> updateUsuario(Long id, UsuarioUpdateDTO dto) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(dto.getNombre());
            usuario.setApellido(dto.getApellido());
            Usuario actualizado = usuarioRepository.save(usuario);
            return new UsuarioResponseDTO(
                    actualizado.getId(),
                    actualizado.getNombre(),
                    actualizado.getApellido(),
                    actualizado.getCorreo());
        });
    }
}
