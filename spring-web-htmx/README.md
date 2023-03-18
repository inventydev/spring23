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

## Dcoker container
Run docker container using docker image
```
docker run -p 8080:8080 spring23/spring-web-htmx
```


# Thymeleaf
[https://www.thymeleaf.org/](https://www.thymeleaf.org/)

# HTMX
[https://htmx.org/docs/](https://htmx.org/docs/)
