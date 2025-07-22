package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para responder con datos del usuario")
public class UserResponseDTO {

    @Schema(description = "ID del usuario")
    private Long id;

    @Schema(description = "Nombre del usuario")
    private String name;

    @Schema(description = "Apellido del usuario")
    private String lastName;

    @Schema(description = "Correo electrónico del usuario")
    private String email;

    // Constructor completo
    public UserResponseDTO(Long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }
}
