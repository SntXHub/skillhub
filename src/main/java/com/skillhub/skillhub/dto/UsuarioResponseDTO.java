package com.skillhub.skillhub.dto;

public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String correo;

    public UsuarioResponseDTO(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters
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
