package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO para realizar login con email y contraseña")
public class LoginRequest {

    @Schema(description = "Correo electrónico del usuario", example = "usuario@example.com", required = true)
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El correo debe tener un formato válido")
    private String email;

    @Schema(description = "Contraseña del usuario", example = "claveSegura123", required = true)
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    // Getters y Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
