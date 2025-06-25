package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioDTO;
import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // POST: /api/usuarios/registrar
    @PostMapping("/registrar")
    public UsuarioResponseDTO registrar(@RequestBody UsuarioDTO dto) {
        if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con ese correo");
        }

        String contraseñaEncriptada = passwordEncoder.encode(dto.getContraseña());

        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .contraseña(contraseñaEncriptada)
                .build();

        Usuario guardado = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(guardado.getId(), guardado.getNombre(), guardado.getCorreo());
    }

    // GET: /api/usuarios
    @GetMapping
    public List<UsuarioResponseDTO> obtenerTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getCorreo()))
                .toList();
    }
}
