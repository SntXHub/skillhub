package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioDTO;
import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // POST: /api/usuarios/registrar
        @PostMapping("/registrar")
        public ResponseEntity<?> registrar(@Valid @RequestBody UsuarioDTO dto) {
                if (usuarioRepository.findByCorreo(dto.getCorreo()).isPresent()) {
                        return ResponseEntity
                                        .status(HttpStatus.CONFLICT)
                                        .body("El correo ya está registrado.");
                }

                String contraseñaEncriptada = passwordEncoder.encode(dto.getContraseña());

                Usuario usuario = Usuario.builder()
                                .nombre(dto.getNombre())
                                .correo(dto.getCorreo())
                                .contraseña(contraseñaEncriptada)
                                .build();

                Usuario creado = usuarioRepository.save(usuario);

                UsuarioResponseDTO response = new UsuarioResponseDTO(
                                creado.getId(),
                                creado.getNombre(),
                                creado.getCorreo());

                return ResponseEntity.status(HttpStatus.CREATED).body(response);
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

        // ✅ NUEVO: GET /api/usuarios/perfil
        @GetMapping("/perfil")
        public ResponseEntity<UsuarioResponseDTO> obtenerPerfil(Authentication authentication) {
                String correo = authentication.getName();
                Usuario usuario = usuarioRepository.findByCorreo(correo)
                                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

                UsuarioResponseDTO response = new UsuarioResponseDTO(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getCorreo());

                return ResponseEntity.ok(response);
        }
}
