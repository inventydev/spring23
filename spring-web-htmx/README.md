# Spring boot 3 app with thymeleaf templates and htmx

## Build and generate the jar file

```
./gradlew clean build
```

## Run the jar package

```
java -jar ./build/libs/spring-web-htmx-0.0.1-SNAPSHOT.jar
```

## Java version
Java version: 17

## Install Java using sdk manager 

Use SDKMAN tool to install different versions on Java and manage default version.   
Install instructions: [https://sdkman.io/install](https://sdkman.io/install)  

List available java versions  
```
sdk list java
``` 

Install java 17

```
sdk install java 17.0.5-tem
```

## Install Java from the temurin page:
[https://adoptium.net/temurin/releases/](https://adoptium.net/temurin/releases/) 


# Docker

## Docker file
Use java version 17 temurin  
Copy the package .jar file as app.jar  
Run `java -jar /app.jar`  

```
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Docker image
Build docker image  
```
docker build -t spring23/spring-web-htmx .
```

## Docker container
Run docker container using docker image
```
docker run -p 8080:8080 spring23/spring-web-htmx
```

# Open app in browser

[http://localhost:8080/](http://localhost:8080/)


# Env variables
Encode your password using [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html)
```
spring encodepassword password
{bcrypt}$2a$10$X5wFBtLrL/kHcmrOGGTrGufsBX8CJ0WpQpF3pgeuxBB/H73BK1DW6
```
Set environment variables
```
export ADMIN_PASSWORD='{bcrypt}$2a$10$X5wFBtLrL/kHcmrOGGTrGufsBX8CJ0WpQpF3pgeuxBB/H73BK1DW6'
export USER_PASSWORD='{bcrypt}$2a$10$X5wFBtLrL/kHcmrOGGTrGufsBX8CJ0WpQpF3pgeuxBB/H73BK1DW6'
```

# If you deploy your app on the [railway.app](https://railway.app?referralCode=hZtZGt) add env variables to the deployment  
Use the values generated with the Spring Boot CLI  

VARIABLE_NAME: ADMIN_PASSWORD  
VALUE: {bcrypt}$2a$10$X5wFBtLrL/kHcmrOGGTrGufsBX8CJ0WpQpF3pgeuxBB/H73BK1DW6  


VARIABLE_NAME: USER_PASSWORD  
VALUE: {bcrypt}$2a$10$X5wFBtLrL/kHcmrOGGTrGufsBX8CJ0WpQpF3pgeuxBB/H73BK1DW6  

# Thymeleaf
[https://www.thymeleaf.org/](https://www.thymeleaf.org/)  

# HTMX  
[https://htmx.org/docs/](https://htmx.org/docs/)  
