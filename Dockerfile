
FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
ADD target/spring-boot-2-rest-api.jar spring-boot-2-rest-api.jar
ENTRYPOINT ["java","-jar","/spring-boot-2-rest-api.jar"]