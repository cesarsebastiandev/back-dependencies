# 🧾 API de Dependencias - Spring Boot

RESTAPI desarrollada en Java 21 con Spring Boot 3.5.6 que expone los endpoints de un crud de dependencias. La base de datos PostgreSQL corre en un contenedor de Docker.

---

## 🚀 Tecnologías Utilizadas

- Java 21
- Spring Boot 3.5.6
- Maven
- Spring Data JPA (Hibernate)
- PostgreSQL (via Docker)
- springdoc-openapi-starter-webmvc-ui
- Docker + Docker Compose

---
## 🎥 Video demostrativo

Puedes encontrar una breve explicación del funcionamiento del proyecto en el siguiente video:

[Ver video aqui](https://drive.google.com/file/d/1Qlr3WQ9giRVKr-5C-GcqmmHXwpEW4_Nu/view?usp=sharing)
---

## ⚙️ Configuración del Proyecto
### Abre una terminal
### Clona el repositorio con SSH

```
git clone git@gitlab.com:cesar-sebastian/back-dependencies.git
```
### O Clona el repositorio con HTTPS
```
git clone https://gitlab.com/cesar-sebastian/back-dependencies.git
```
### Ubicarse en la carpeta del proyecto
```
cd back-dependencies
```
### La base de datos se encuentra en un contenedor de Docker, lo construyes con:
```
docker-compose up -d
```
### Ahora debes levantar el contedor con:
```
docker-compose up
```
### Ver si el contenedor esta corriendo
```
docker ps
```
### Detener el contenedor, puedes abrir otra terminal y poner
```
docker stop container-dependencies
```
### ⚠️ NOTA IMPORTANTE, LEER:
### Si no usas docker y tienes pgAdmin instalado en tu maquina, debes crear manualmente una base de datos con el nombre:
```
db-dependencies
```
### Actualizar `application.properties`

#### Edita el archivo ubicado en: `src/main/resources/application.properties`

### Debes cambiar estas propiedades, para que coincidan con tu entorno local:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/db-dependencies
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
### Al abrir el proyecto con Intellij IDEA, las dependencias se descargan de forma automatica
### Finalmente, solo debes correr el proyecto de Spring Boot en tu IDE favorito (Intellij IDEA o VSCODE)
### Puedes usar un cliente para conectarte a la base de datos (Datagrip, DBGate, DBeaver, etc).
### Haces un ping al server, te devuelve un pong

```
http://localhost:8080
```

### La docs de swagger la encuentras aqui:

```
http://localhost:8080/swagger-ui/index.html
```










