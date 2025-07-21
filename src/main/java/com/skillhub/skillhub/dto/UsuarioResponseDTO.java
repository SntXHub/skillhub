package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para responder con datos del usuario")
public class UsuarioResponseDTO {

    @Schema(description = "ID del usuario")
    private Long id;

    @Schema(description = "Nombre del usuario")
    private String nombre;

    @Schema(description = "Apellido del usuario")
    private String apellido;

    @Schema(description = "Correo electrónico del usuario")
    private String correo;

    // Constructor completo
    public UsuarioResponseDTO(Long id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
}

// Utilizando Conventional Commits
