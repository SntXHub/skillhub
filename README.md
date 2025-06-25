# SkillHub - Backend (Spring Boot)

Proyecto backend para SkillHub, una plataforma de gestión de usuarios y habilidades, desarrollada con tecnologías modernas del ecosistema Java.

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.3
- Spring Data JPA
- Spring Security
- Swagger (OpenAPI 3)
- MariaDB (compatible con MySQL)
- Lombok
- Maven
- Git y GitHub
- Postman

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

## 📮 API disponible

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

### GET /api/usuarios

Requiere autenticación básica (HTTP Basic Auth). Devuelve una lista de usuarios registrados, sin exponer contraseñas.

---

## 🧭 Documentación interactiva (Swagger)

Una vez ejecutada la aplicación, accedé a la documentación de la API en:

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## ✅ Estado actual del proyecto

- ✔️ Backend funcional
- ✔️ Registro de usuarios con contraseña encriptada
- ✔️ Seguridad básica (HTTP Basic con Spring Security)
- ✔️ Documentación Swagger/OpenAPI funcionando
- ⚙️ Entorno de desarrollo estable

---

## 🧪 Pruebas realizadas

Verificado con Postman:

- Registro de usuario → ✅
- Autenticación básica → ✅
- Acceso autenticado a endpoints protegidos → ✅
- Visualización en Swagger → ✅

---

## 🔒 Buenas prácticas aplicadas

- Contraseñas encriptadas con BCrypt
- Contraseñas excluidas de respuestas JSON (uso de DTO)
- Separación de configuración sensible (`application.properties` no versionado)
- Uso de `UserDetailsService` personalizado
- `SecurityFilterChain` moderna (sin usar WebSecurityConfigurerAdapter)

---

## 🧑‍💻 Entorno de desarrollo

- Sistema operativo: Debian 12
- IDE: Visual Studio Code
- Java 17
- Base de datos: MariaDB
- Swagger UI para documentación de API
- Postman para pruebas manuales
- Terminal: Tilix + Tmux

---

## 📌 Próximos pasos

- Implementar autenticación con JWT
- Agregar endpoints para login y logout
- Crear entidades y relaciones: Perfiles, Habilidades, Roles
- Validaciones de formularios (Bean Validation)
- Manejo global de errores con excepciones personalizadas

---

## 🤝 Contribución

Podés colaborar abriendo issues o enviando pull requests.  
Toda sugerencia o reporte de error es bienvenido.

---

## 📄 Licencia

Este proyecto es de carácter académico y formativo. Puede reutilizarse con fines educativos.

