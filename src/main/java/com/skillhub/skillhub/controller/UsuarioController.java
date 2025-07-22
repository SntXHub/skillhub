package com.skillhub.skillhub.controller;

import com.skillhub.skillhub.dto.UsuarioResponseDTO;
import com.skillhub.skillhub.dto.UsuarioUpdateDTO;
import com.skillhub.skillhub.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

        private final UsuarioService usuarioService;

        public UsuarioController(UsuarioService usuarioService) {
                this.usuarioService = usuarioService;
        }

        @Operation(summary = "Obtener perfil del usuario autenticado")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Perfil obtenido correctamente"),
                        @ApiResponse(responseCode = "401", description = "No autorizado")
        })
        @GetMapping("/perfil")
        public ResponseEntity<UsuarioResponseDTO> obtenerPerfil() {
                UsuarioResponseDTO perfil = usuarioService.obtenerPerfilActual();
                return ResponseEntity.ok(perfil);
        }

        @Operation(summary = "Actualizar nombre y apellido de un usuario")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente"),
                        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
        })
        @PutMapping("/{id}")
        public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(
                        @PathVariable Long id,
                        @Valid @RequestBody UsuarioUpdateDTO dto) {

                return usuarioService.updateUsuario(id, dto)
                                .map(ResponseEntity::ok)
                                .orElse(ResponseEntity.notFound().build());
        }
}
