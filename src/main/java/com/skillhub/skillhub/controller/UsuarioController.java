package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody UsuarioDTO dto) {
        String contraseñaEncriptada = passwordEncoder.encode(dto.getContraseña());

        Usuario usuario = Usuario.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .contraseña(contraseñaEncriptada)
                .build();

        return usuarioRepository.save(usuario);
    }
}
