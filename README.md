# OPEN MOVIE APPLICATION

# Architecture

![openMovieAPI](https://user-images.githubusercontent.com/69572868/232414971-2d923df4-500d-4ed1-9992-0ff8d00fafdc.png)

# The service provides an API
  To search movie report by movie name.

# How does the application works?
  Application receives the requested via /v1/api/movie/{movieTitle} url with {movieTitle} path variables
  Movie report can be fetch either from database or TheMovieDatabase with the API_KEY
  On the swagger page you can find the relevant api endpoint. You can reach the openapi page by http://localhost:8080/swagger-ui/index.html url.
  
  # Technologies
    Java 17
    Spring Boot 3.0
    Open API Documentation
    Spring Data JPA
    H2 In Memory Database
    Restful API
    Maven
    Junit5
    Mockito
    Integration Tests
    Docker
    Docker Compose
    Github Actions
    Prometheus
    Grafana
    
# Prerequisites
  Maven or Docker
  
# Docker Run
  The application can be built and run by the Docker engine. The Dockerfile has multistage build, so you do not need to build and run separately.
  Please follow the below directions in order to build and run the application with Docker Compose;

    $ cd movieAPI

    $ docker-compose up -d
  
  Docker compose creates 3 replicas (instances) of the application on port range 9595-9597
  
    You can reach the open-api-ui via http://{HOST}:{9595-9597}/swagger-ui.html
  
# Prometheus
    You can reach prometheus page via http://{HOST}:9090
  
# Grafana

    You can reach grafana page via http://{HOST}:3000 - GF_SECURITY_ADMIN_PASSWORD=admin

# Maven Run
To build and run the application with Maven, please follow the directions below;

    $ cd open-weather

    $ mvn clean install

    $ mvn spring-boot:run

You can reach the swagger-ui via http://{HOST}:8080/swagger-ui.html
