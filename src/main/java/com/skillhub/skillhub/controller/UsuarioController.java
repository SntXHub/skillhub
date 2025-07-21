package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioDTO;
import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UsuarioController {

        private final UsuarioRepository usuarioRepository;
        private final PasswordEncoder passwordEncoder;

        public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
                this.usuarioRepository = usuarioRepository;
                this.passwordEncoder = passwordEncoder;
        }

        @PostMapping("/registrar")
        @Operation(summary = "Registrar nuevo usuario")
        public ResponseEntity<UsuarioResponseDTO> registrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
                if (usuarioRepository.existsByCorreo(usuarioDTO.getCorreo())) {
                        return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }

                Usuario nuevoUsuario = Usuario.builder()
                                .nombre(usuarioDTO.getNombre())
                                .apellido(usuarioDTO.getApellido())
                                .correo(usuarioDTO.getCorreo())
                                .contraseña(passwordEncoder.encode(usuarioDTO.getContraseña()))
                                .build();

                Usuario creado = usuarioRepository.save(nuevoUsuario);

                UsuarioResponseDTO response = new UsuarioResponseDTO(
                                creado.getId(),
                                creado.getNombre(),
                                creado.getApellido(),
                                creado.getCorreo());

                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @GetMapping("/perfil")
        @Operation(summary = "Obtener el perfil del usuario autenticado", security = @SecurityRequirement(name = "bearerAuth"))
        public ResponseEntity<UsuarioResponseDTO> obtenerPerfil(@AuthenticationPrincipal UserDetails userDetails) {
                String correo = userDetails.getUsername();
                Usuario usuario = usuarioRepository.findByCorreo(correo).orElse(null);

                if (usuario == null) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }

                UsuarioResponseDTO response = new UsuarioResponseDTO(
                                usuario.getId(),
                                usuario.getNombre(),
                                usuario.getApellido(),
                                usuario.getCorreo());

                return ResponseEntity.ok(response);
        }

        @GetMapping
        @Operation(summary = "Listar todos los usuarios (no requiere autenticación)")
        public List<UsuarioResponseDTO> listarUsuarios() {
                return usuarioRepository.findAll()
                                .stream()
                                .map(usuario -> new UsuarioResponseDTO(
                                                usuario.getId(),
                                                usuario.getNombre(),
                                                usuario.getApellido(),
                                                usuario.getCorreo()))
                                .collect(Collectors.toList());
        }
}

// Utilizando Conventional Commits
