Proyecto backend (Maven) — generar WAR y desplegar en Tomcat

1) Construir el WAR

Windows (desde la raíz del workspace):

```powershell
cd backend
mvn package
```

El WAR resultante estará en `backend\target\backend-1.0-SNAPSHOT.war`.

2) Instalar Apache Tomcat (local Windows)

- Descargar Tomcat 9 (recomendado para javax.servlet): https://tomcat.apache.org/download-90.cgi
- Descomprimir en `C:\apache-tomcat-9.x`.
- Iniciar Tomcat: `C:\apache-tomcat-9.x\bin\startup.bat`

3) Desplegar el WAR

- Copiar el archivo WAR a `C:\apache-tomcat-9.x\webapps\` y Tomcat lo desplegará automáticamente.
- Alternativa: habilitar el Manager y subir el WAR desde la interfaz web (requiere configurar `conf/tomcat-users.xml`).

Nota sobre Tomcat 10+: si usas Tomcat 10 o superior, cambia las importaciones a `jakarta.servlet.*` y la dependencia a `jakarta.servlet:jakarta.servlet-api`.
