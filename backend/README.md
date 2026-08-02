# Proyecto backend (Maven) — generar WAR y desplegar en Tomcat

## Descripción del proyecto

Proyecto desarrollado para la gestión del módulo de clientes del sistema MaizON.

El proyecto implementa un servicio web utilizando Java con arquitectura basada en Servlet, DAO, Modelo y conexión a base de datos, permitiendo registrar clientes mediante una API.

---

# Estructura del proyecto

```
Proyecto_2026

├── backend
│   ├── conexion
│   ├── dao
│   ├── modelo
│   └── servlet
│
└── frontend
    ├── index.html
    ├── clientes.js
    └── css
        └── styles.css
```

---

# Construcción del proyecto WAR

## 1) Construir el WAR

Desde la raíz del workspace ejecutar:

```powershell
cd backend
mvn package
```

El archivo WAR generado estará ubicado en:

```
backend\target\backend-1.0-SNAPSHOT.war
```

---

# Despliegue en Apache Tomcat

## 2) Instalación de Apache Tomcat

- Descargar Apache Tomcat 9.
- Descomprimir en una ubicación local.

Ejemplo:

```
C:\apache-tomcat-9.x
```

Iniciar el servidor:

```
C:\apache-tomcat-9.x\bin\startup.bat
```

---

## 3) Desplegar el archivo WAR

Copiar el archivo:

```
backend-1.0-SNAPSHOT.war
```

dentro de:

```
C:\apache-tomcat-9.x\webapps\
```

Tomcat realizará el despliegue automáticamente.

---

# Documentación de Servicios Web

## Servicio de Clientes

### Nombre del servicio

ClienteServlet

### Ruta del servicio

```
/clientes
```

---

# Método GET

## Descripción

Permite comprobar que el módulo de clientes se encuentra funcionando correctamente.

## Petición

```
GET /clientes
```

## Respuesta

```
Modulo clientes MaizON funcionando
```

---

# Método POST

## Descripción

Permite registrar un nuevo cliente en el sistema.

## Petición

```
POST /clientes
```

## Datos recibidos

| Parámetro | Tipo de dato |
|-----------|--------------|
| nombre | String |
| telefono | String |
| correo | String |
| direccion | String |

---

## Ejemplo de envío

```
nombre=Juan Perez
telefono=3000000000
correo=juan@gmail.com
direccion=Colombia
```

---

# Respuestas del servicio

## Registro exitoso

```
Cliente guardado correctamente
```

## Error en el registro

```
Error al guardar cliente
```

---

# Arquitectura del proyecto

## Modelo

Contiene la clase Cliente con los atributos:

- Nombre
- Teléfono
- Correo
- Dirección

---

## DAO

El componente DAO permite la comunicación con la base de datos y realiza la operación de almacenamiento de clientes.

---

## Conexión

Administra la conexión entre la aplicación y la base de datos.

---

## Servlet

El `ClienteServlet` recibe las solicitudes del frontend y ejecuta las operaciones correspondientes mediante el DAO.

---

## Frontend

La interfaz fue desarrollada con:

- HTML
- CSS
- JavaScript

Permitiendo ingresar los datos del cliente y enviarlos al servicio web.

---

# Tecnologías utilizadas

- Java
- Maven
- Apache Tomcat
- Servlet API
- HTML
- CSS
- JavaScript
- Base de datos relacional

---

# Versionamiento

El proyecto cuenta con un repositorio donde se almacena el código fuente y sus respectivas versiones.

Repositorio:

https://github.com/blakman11/proyecto_2026.git

---

