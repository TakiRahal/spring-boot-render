# Deploy Sprint Boot And Postegres on Render with Web Services and Docker

## Creat Spring Boot Project

    https://start.spring.io/

## Add Dependencies Web : spring-boot-starter-web

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

## Add Dependencies JPA
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

## Add Dependencies PostegreSql : postgresql

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>


### Create Dockerfile at the root folder

    #
    # Build stage
    #
    FROM maven:3.8.2-jdk-11 AS build
    COPY . .
    RUN mvn clean package -Pprod -DskipTests
    
    #
    # Package stage
    #
    FROM openjdk:11-jdk-slim
    COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
    # ENV PORT=8080
    EXPOSE 8080
    ENTRYPOINT ["java","-jar","demo.jar"]
    

### Building a Dockerfile from the root folder
    By default docker uses the Dockerfile of the current folder if you run a single command like
    Run: docker build -t spring-boot-render .
    
### Run image with docker on localhost
    Run docker run -p 8080:8080 spring-boot-render


## Create Postegres database from Render.com
    https://dashboard.render.com/


### Modify connections params on application.properties

    server.tomcat.accesslog.enabled=true
    
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.hibernate.show-sql=true

    spring.datasource.url=jdbc:postgresql://dpg-{custom-url}.render.com:5432/{name_database}
    spring.datasource.username=your_username
    spring.datasource.password=your_passeword
    spring.datasource.driver-class-name=org.postgresql.Driver


### Creat new Web Service app


## DEMO 
    
[![IMAGE ALT TEXT HERE](https://github.com/TakiRahal/spring-boot-render/blob/main/src/main/resources/static/spring_boot_render.png)](https://youtu.be/-Ih_ky5HMEA)
