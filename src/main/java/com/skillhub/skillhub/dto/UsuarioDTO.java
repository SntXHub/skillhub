package com.skillhub.skillhub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "DTO para el registro de un nuevo usuario")
public class UsuarioDTO {

    @Schema(description = "Nombre del usuario", example = "Santiago", required = true)
    @NotBlank(message = "El nombre es obligatorio.")
    private String nombre;

    @Schema(description = "Apellido del usuario", example = "Cabrera", required = true)
    @NotBlank(message = "El apellido es obligatorio.")
    private String apellido;

    @Schema(description = "Correo electrónico del usuario", example = "santiago@example.com", required = true)
    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo debe tener un formato válido.")
    private String correo;

    @Schema(description = "Contraseña del usuario (mínimo 6 caracteres)", example = "123456", required = true)
    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres.")
    private String contraseña;
}

// Utilizando Conventional Commits
