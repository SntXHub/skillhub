package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UserResponseDTO;
import com.skillhub.skillhub.dto.UserUpdateDTO;
import com.skillhub.skillhub.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

        private final UserService userService;

        public UserController(UserService userService) {
                this.userService = userService;
        }

        @Operation(summary = "Obtener perfil del usuario autenticado")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Perfil obtenido correctamente"),
                        @ApiResponse(responseCode = "401", description = "No autorizado")
        })
        @GetMapping("/profile")
        public ResponseEntity<UserResponseDTO> getProfile() {
                UserResponseDTO profile = userService.getCurrentProfile();
                return ResponseEntity.ok(profile);
        }

        @Operation(summary = "Actualizar nombre y apellido de un usuario")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
                        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
        })
        @PutMapping("/{id}")
        public ResponseEntity<UserResponseDTO> updateUser(
                        @PathVariable Long id,
                        @Valid @RequestBody UserUpdateDTO dto) {

                return userService.updateUsuario(id, dto)
                                .map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build());
        }
}
