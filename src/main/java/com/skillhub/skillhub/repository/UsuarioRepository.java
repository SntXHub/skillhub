package com.skillhub.skillhub.repository;

import com.skillhub.skillhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo); // Método agregado para verificar existencia por correo
}

// Utilizando Conventional Commits
