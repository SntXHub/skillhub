package com.skillhub.skillhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta del login con token JWT")
public class LoginResponse {

    @Schema(description = "Token JWT de autenticación", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
