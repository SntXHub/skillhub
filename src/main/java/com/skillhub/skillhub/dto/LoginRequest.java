package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Credenciales de login")
public class LoginRequest {

    @Schema(description = "Correo del usuario", example = "usuario@example.com", required = true)
    private String correo;

    @Schema(description = "Contraseña del usuario", example = "123456", required = true)
    private String contraseña;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
