package com.skillhub.skillhub.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String correo;
    private String contraseña;
}
