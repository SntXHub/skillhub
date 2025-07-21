package com.skillhub.skillhub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido; // ← NUEVO CAMPO

    @Column(unique = true)
    private String correo;

    private String contraseña;

    // Podés agregar otros campos como rol, fechaRegistro, etc. más adelante si hace
    // falta
}

// Utilizando Conventional Commits
