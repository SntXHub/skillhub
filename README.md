# SkillHub - Backend (Spring Boot)

Proyecto backend para SkillHub, una aplicación orientada a la gestión de usuarios y habilidades, desarrollado con Spring Boot y MariaDB.

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- MariaDB (soportado también MySQL)
- Lombok
- Maven
- Postman (para pruebas)
- Git y GitHub

## ⚙️ Configuración inicial

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/sntxhub/skillhub-backend.git
   cd skillhub-backend
   ```

2. Crear la base de datos:

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

5. Ejecutar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

## 📮 API inicial disponible

### POST /api/usuarios/registrar

Registra un nuevo usuario.

**Body (JSON):**

```json
{
  "nombre": "Nombre Apellido",
  "correo": "usuario@email.com",
  "contraseña": "password123"
}
```

**Respuesta esperada (ejemplo):**

```json
{
  "id": 1,
  "correo": "usuario@email.com",
  "nombre": "Nombre Apellido",
  "contraseña": "$2a$10$..."
}
```

La contraseña es almacenada de forma segura mediante el algoritmo `BCrypt`.

## 📦 Estado actual del proyecto

- ✅ Backend funcional
- ✅ Registro de usuarios con contraseña encriptada
- 🔐 Seguridad básica configurada (Spring Security)
- 🛠️ En desarrollo: login, autenticación JWT, estructura de perfiles y habilidades

---

## 🚧 Avances recientes

### 🔐 Seguridad

- Implementada autenticación básica (HTTP Basic Auth) con Spring Security.
- Configuración inicial en `SecurityConfig.java`, habilitando el endpoint de registro como público.
- Los demás endpoints requieren autenticación.

### 👤 Usuarios

- Endpoint `POST /api/usuarios/registrar`: permite registrar un nuevo usuario. La contraseña se encripta con BCrypt.
- Endpoint `GET /api/usuarios`: requiere autenticación y devuelve una lista de usuarios sin incluir las contraseñas (uso de `UsuarioResponseDTO`).

### 🧪 Pruebas realizadas

- Verificado en Postman:
  - Registro de usuario → ✅
  - Acceso autenticado a listado de usuarios → ✅
  - Protección de contraseña en respuesta JSON → ✅

---

## 🔒 Buenas prácticas aplicadas

- Contraseñas no visibles en respuestas JSON.
- `application.properties` ignorado por Git y reemplazado por `application-example.properties`.

---

## 🧪 Entorno de desarrollo utilizado

- Sistema operativo: Linux Debian 12
- IDE principal: VS Code
- Base de datos: MariaDB
- Docker disponible para pruebas futuras
- Postman para pruebas de endpoints

---

## 🤝 Contribución

Si querés colaborar, podés abrir un issue o enviar un pull request.  
Para cualquier sugerencia, mejora o error, no dudes en avisar.

---

## 📄 Licencia

Este proyecto se encuentra en desarrollo académico y formativo. Puede adaptarse o reutilizarse con fines educativos y personales. Créditos al autor original.

---
