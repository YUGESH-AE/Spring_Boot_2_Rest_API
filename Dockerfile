#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/spring-boot-2-rest-api.jar spring_boot_2_rest_api.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring_boot_2_rest_api.jar"]
