# SkillHub - Backend (Spring Boot)

Backend para **SkillHub**, una plataforma de gestión de usuarios y habilidades. Este proyecto está desarrollado con tecnologías modernas del ecosistema Java, e implementa autenticación segura mediante JWT.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security (JWT)
- Swagger / OpenAPI 3
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

### POST `/api/auth/login`

Devuelve un JWT válido para autenticación de endpoints protegidos.

**Body (JSON):**

```json
{
  "correo": "usuario@email.com",
  "contraseña": "password123"
}
```

### GET `/api/usuarios`

Devuelve todos los usuarios registrados (requiere autenticación con JWT).

### GET `/api/usuarios/perfil`

Devuelve los datos del usuario autenticado.

---

## 🧭 Documentación interactiva (Swagger)

Una vez ejecutada la aplicación, podés acceder a la documentación interactiva en:

🔗 [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

## ✅ Estado actual del proyecto

- ✔️ Backend funcional y estable
- ✔️ Registro de usuarios con encriptación bcrypt
- ✔️ Inicio de sesión con JWT
- ✔️ Seguridad con `CustomUserDetailsService` y filtros JWT
- ✔️ Documentación Swagger operativa
- ✔️ Endpoints protegidos por roles aún no implementados
- ✔️ Pruebas exitosas con Postman

---

## 🧪 Pruebas realizadas

Probado y verificado con Postman:

- ✅ POST `/api/usuarios/registrar`: creación de usuarios con contraseña encriptada
- ✅ POST `/api/auth/login`: genera token JWT válido
- ✅ GET `/api/usuarios/perfil`: autenticación con JWT correcta
- ✅ Swagger cargando correctamente los endpoints
- ✅ No se expone la contraseña en respuestas (uso correcto de DTOs)

---

## 🔒 Buenas prácticas aplicadas

- Uso de `BCryptPasswordEncoder` para contraseñas
- Exclusión de campos sensibles en las respuestas
- Separación de configuración sensible (`application.properties` no versionado)
- Uso de DTOs para entrada y salida de datos
- Autenticación JWT mediante `JwtAuthenticationFilter`
- Configuración moderna de seguridad (`SecurityFilterChain`)

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

- 🔄 Validación para evitar correos duplicados al registrar
- ⚠️ Manejo de errores (400, 401, 409, etc.)
- 🧾 Mejorar documentación Swagger con descripciones y ejemplos
- 🔐 Implementar roles y permisos (ADMIN, USER)
- 🧪 Añadir pruebas unitarias e integración
- ☁️ Configurar entorno para despliegue futuro

---

## 🤝 Contribución

Podés colaborar abriendo issues o enviando pull requests.  
Toda sugerencia, mejora o reporte de error es bienvenido.

---

## 📄 Licencia

Proyecto académico y formativo. Puede ser reutilizado con fines educativos.

---
