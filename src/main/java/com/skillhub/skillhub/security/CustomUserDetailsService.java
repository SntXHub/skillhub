package com.skillhub.skillhub.security;

import com.skillhub.skillhub.model.Usuario;
import com.skillhub.skillhub.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    // Constructor sin @Autowired (opcional desde Spring 4.3 si solo hay uno)
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));

        return new User(
                usuario.getCorreo(),
                usuario.getContraseña(),
                Collections.emptyList() // Aún sin roles definidos
        );
    }
}
