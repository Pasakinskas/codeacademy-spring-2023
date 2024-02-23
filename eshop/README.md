# E-Shop
WEB for Spring MVC learning

### Prerequisites
This project used Bootstrap 5 and Spring Boot 3.2.1.
Spring Security version 6.2 included.

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17

## Run DB with Docker
### Run mysql
```
docker compose up -d mysqldb
```

### Run postgres
```
docker compose up -d postgresqldb
```

### Run pgAdmin for postgres
```
docker compose up -d pgadmin4
```

## Run application using spring-boot
### on H2 DB
```
./mvnw spring-boot:run
```

### on mysql DB
```
./mvnw spring-boot:run -Dspring.profiles.active=mysql
```

### on postgresql DB
```
./mvnw spring-boot:run -Dspring.profiles.active=pg
```

## Access the application
http://localhost:8080

## Access Swagger (using OpenAPI)
The Swagger UI page will then be available at http://localhost:8080/swagger-ui.html 
and the OpenAPI description will be available at the following url for json format: http://localhost:8080/v3/api-docs