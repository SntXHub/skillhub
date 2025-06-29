package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para la respuesta con datos del usuario")
public class UsuarioResponseDTO {

    @Schema(description = "ID del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del usuario", example = "Santiago Cabrera")
    private String nombre;

    @Schema(description = "Correo electrónico del usuario", example = "santiago@example.com")
    private String correo;

    public UsuarioResponseDTO(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
