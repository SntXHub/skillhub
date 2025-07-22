package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioUpdateDTO {

    @Schema(description = "Nombre del usuario", example = "Juan", required = true)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Schema(description = "Apellido del usuario", example = "Pérez", required = true)
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    // En esta etapa no se permite cambiar el correo ni la contraseña
}
