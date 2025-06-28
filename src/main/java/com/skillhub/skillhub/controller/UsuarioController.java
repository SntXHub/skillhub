package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioDTO;
import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        @Operation(summary = "Registrar un nuevo usuario", description = "Registra un nuevo usuario con nombre, correo y contraseña. La contraseña se almacena encriptada.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponseDTO.class))),
                        @ApiResponse(responseCode = "409", description = "El correo ya está registrado"),
                        @ApiResponse(responseCode = "400", description = "Datos inválidos enviados")
        })
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

        @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista con todos los usuarios registrados.")
        @ApiResponse(responseCode = "200", description = "Lista de usuarios devuelta exitosamente")
        @GetMapping
        public List<UsuarioResponseDTO> obtenerTodos() {
                return usuarioRepository.findAll()
                                .stream()
                                .map(usuario -> new UsuarioResponseDTO(
                                                usuario.getId(),
                                                usuario.getNombre(),
                                                usuario.getCorreo()))
                                .collect(Collectors.toList());
        }

        @Operation(summary = "Obtener el perfil del usuario autenticado", description = "Devuelve los datos del usuario actualmente autenticado.")
        @ApiResponse(responseCode = "200", description = "Perfil devuelto exitosamente")
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
