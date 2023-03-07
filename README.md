# Spring-CRUD-thymeleaf

run sql query to create databse
![image](https://user-images.githubusercontent.com/120351896/213962198-238f8aaa-f8a5-4049-9b55-c1ac5721a3fb.png)

input username and password
![image](https://user-images.githubusercontent.com/120351896/213962229-4b3730b8-aa34-41b4-aa50-b42cea49639e.png)

database structure
![image](https://user-images.githubusercontent.com/120351896/215641756-786e3e90-2f36-4e13-a54d-3b63af5d9e89.png)

# DOCKER WALKTHROUGH/SETUP
This is an exercise on the use of Spring Boot JPA and Postgres Database

# Convert the Application to JAR File
  Run this command in the current directory
  ./mvnw clean package -DskipTests
  
# Docker Folder
Using the command below copy the jar file from target folder to src\main\docker using the command:
cp target/demo-0.0.1-SNAPSHOT.jar src/main/docker-configuration

# DockerFile Configuration
Create a Docker File under scr\main\docker-configuration folder using the following script:

FROM openjdk:17
LABEL maintainer = "justindelacruz"
ADD demo-0.0.1-SNAPSHOT.jar demo-docker.jar
ENTRYPOINT ["java","-jar","demo-docker.jar"]

# docker-compose.yml

Creat a docke-compose.yml configuration using the following command:

version: '2'

services:
  app:
    image: 'docker-spring-boot-postgres:latest'
    build:
      context: .
    container_name: demo-task
    links:
      - app-db
    ports:
      - 8080:8080
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://app-db:5432/task2
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=102799
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
  app-db:
    image: postgres:9.6
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=102799
      - POSTGRES_DB=task2
    expose:
      - 5432
      
# Run Build
docker-compose up

#Access the End point
Go to the url http://localhost:8080
