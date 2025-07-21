# SkillHub - Backend (Spring Boot)

Backend para **SkillHub**, una plataforma de gestión de usuarios y habilidades. Este proyecto está desarrollado con tecnologías modernas del ecosistema Java e implementa autenticación segura mediante JWT.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.2+
- Spring Data JPA
- Spring Security (JWT)
- Swagger / OpenAPI 3 (`springdoc-openapi-starter-webmvc-ui`)
- MariaDB (compatible con MySQL)
- Lombok
- Maven
- Git y GitHub
- Postman

---

## ⚙️ Configuración inicial

1. Cloná el repositorio:

```bash
git clone https://github.com/sntxhub/skillhub-backend.git
cd skillhub-backend
```

2. Crear la base de datos en MariaDB:

```sql
CREATE DATABASE skillhubdb DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

3. Copiar el archivo de configuración de ejemplo:

```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

4. Editar `application.properties` y completar:

- `spring.datasource.username`
- `spring.datasource.password`
- (Opcional) Cambiar el puerto o configuración JWT

5. Ejecutar la aplicación:

```bash
./mvnw spring-boot:run
```

---

## 📮 Endpoints disponibles

### POST `/api/usuarios/registrar`

Registra un nuevo usuario.

**Body (JSON):**
```json
{
  "nombre": "Nombre Apellido",
  "correo": "usuario@email.com",
  "contraseña": "password123"
}
```

---

### POST `/api/auth/login`

Devuelve un JWT válido para autenticación de endpoints protegidos.

**Body (JSON):**
```json
{
  "correo": "usuario@email.com",
  "contraseña": "password123"
}
```

---

### GET `/api/usuarios` 🔒

Devuelve todos los usuarios registrados.  
**Requiere token JWT** en el header de autorización.

---

### GET `/api/usuarios/perfil` 🔒

Devuelve los datos del usuario autenticado mediante JWT.  
**Requiere token JWT** en el header de autorización.

---

## 🧭 Documentación interactiva (Swagger)

Una vez ejecutada la aplicación, accedé a:

🔗 [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

Para probar los endpoints protegidos:

1. Usá el endpoint de login para obtener un token JWT.
2. Presioná el botón `Authorize` (ícono de candado).
3. Pegá el token en el campo:  
   `Bearer <tu_token_aquí>`

---

## ✅ Estado actual del proyecto

- ✔️ Backend funcional y estable
- ✔️ Registro de usuarios con validación y encriptación bcrypt
- ✔️ Inicio de sesión con JWT
- ✔️ Seguridad implementada con `JwtAuthenticationFilter`
- ✔️ Swagger funcionando con autenticación y documentación detallada
- ✔️ Control de errores comunes
- ✔️ Base de datos persistente (MariaDB)
- ⚠️ Roles aún no implementados

---

## 🧪 Pruebas realizadas

Probado y verificado:

- ✅ POST `/api/usuarios/registrar`: creación de usuarios con validación
- ✅ POST `/api/auth/login`: genera y devuelve token JWT
- ✅ GET `/api/usuarios/perfil`: autenticación y recuperación de perfil
- ✅ GET `/api/usuarios`: listado general protegido por JWT
- ✅ Swagger permite probar todos los endpoints (protegidos y públicos)
- ✅ Pruebas cruzadas con Postman

---

## 🔒 Buenas prácticas aplicadas

- Uso de `BCryptPasswordEncoder` para contraseñas
- Exclusión de campos sensibles en las respuestas (con DTOs)
- Separación de configuración sensible (`application.properties`)
- Autenticación JWT mediante `AuthenticationManager` y filtro personalizado
- Configuración moderna con múltiples `SecurityFilterChain`
- Swagger con anotaciones `@Operation`, `@ApiResponse` y `@SecurityRequirement`

---

## 🧑‍💻 Entorno de desarrollo

- Sistema operativo: Debian 12
- IDE: Visual Studio Code
- Java 17
- Base de datos: MariaDB
- Swagger UI para documentación de API
- Postman para pruebas
- Terminal: Tilix + Tmux

---

## 📌 Próximos pasos

- 🔄 Validación adicional (nombre vacío, contraseña débil, etc.)
- ⚠️ Mejor manejo de errores con controladores globales
- 🔐 Implementar roles y permisos (ADMIN, USER)
- 🧾 Separar la documentación en archivos (`API.md`, `SECURITY.md`, etc.)
- 🧪 Añadir pruebas unitarias e integración
- ☁️ Preparar configuración para despliegue futuro

---

## 🤝 Contribución

Podés colaborar abriendo issues o enviando pull requests.  
Toda sugerencia, mejora o reporte de error es bienvenido.

---

## 📄 Licencia

Proyecto académico y formativo. Puede ser reutilizado con fines educativos.

---
