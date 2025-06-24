# 🛠️ Skillhub Backend

Este proyecto es el backend del sistema **Skillhub**, una plataforma para la gestión de usuarios y futuros módulos de habilidades, autenticación, y perfiles técnicos. Desarrollado en Java con Spring Boot.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.3
- Spring Security
- Spring Data JPA
- Hibernate
- MariaDB
- Maven
- Swagger / Springdoc OpenAPI
- Lombok

---

## 🧱 Estructura del proyecto

```bash
skillhub-backend/
├── pom.xml
├── README.md
├── mvnw / mvnw.cmd
├── src/
│   ├── main/
│   │   ├── java/com/skillhub/skillhub/
│   │   │   ├── config/                  # Configuraciones de seguridad (SecurityConfig)
│   │   │   ├── controller/              # Controlador REST (UsuarioController)
│   │   │   ├── dto/                     # Clases DTO (UsuarioDTO, UsuarioResponseDTO)
│   │   │   ├── model/                   # Entidades JPA (Usuario)
│   │   │   ├── repository/              # Repositorios Spring Data JPA (UsuarioRepository)
│   │   │   ├── security/                # Servicios de seguridad (CustomUserDetailsService)
│   │   │   └── SkillhubApplication.java # Clase principal
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-example.properties
│   └── test/
│       └── java/com/skillhub/skillhub/
│           └── SkillhubApplicationTests.java
```

---

## 🔐 Seguridad

Se implementó **Spring Security** con autenticación básica (`HTTP Basic Auth`). Las contraseñas son encriptadas usando BCrypt.

- `POST /api/usuarios/registrar`: Permite registrar un nuevo usuario.
- `GET /api/usuarios`: Retorna la lista de usuarios registrados (requiere autenticación).

> Actualmente no se gestionan roles ni permisos avanzados.

---

## 🧪 Pruebas en Postman

- ✅ `POST /api/usuarios/registrar` funciona correctamente.
- ✅ `GET /api/usuarios` responde con 200 OK y muestra los usuarios sin exponer las contraseñas.

---

## 📘 Documentación Swagger

Swagger UI ya está integrado para facilitar el desarrollo y la prueba de la API.

- Acceso local a la documentación interactiva:

```
http://localhost:8080/swagger-ui/index.html
```

Desde Swagger podés:

- Ver los endpoints disponibles.
- Probar peticiones directamente desde el navegador.
- Consultar modelos de datos (DTOs).
- Autenticarse con usuario/contraseña para rutas protegidas.

---

## ⚙️ Recomendaciones de desarrollo

- **Detener/Reiniciar la app:** Usar el botón de depuración de VS Code o `Ctrl+C` en la terminal.
- **Ejecución en VS Code:** Se configuró correctamente el `launch.json`.
- **Swagger y Postman:** Usar usuarios reales con credenciales válidas para probar rutas protegidas.

---

## 📌 Pendientes para próximas tareas

- Agregar validaciones de campos en registro.
- Implementar control de errores centralizado.
- Agregar roles y autorización basada en roles.
- Conectar con un frontend (por ejemplo React).
- Expandir endpoints para CRUD completo.
- Mejorar DTOs y mapeos.
- Escribir tests unitarios y de integración.

---

## 🤝 Contribuciones

Este proyecto está en desarrollo inicial. Se agradecen aportes, sugerencias y mejoras.
