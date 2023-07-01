#
# Build stage
#
FROM maven:3.8.4-openjdk-17-slim AS Build
WORKDIR /app
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM adoptopenjdk:17-jdk-hotspot AS Package
WORKDIR /app
COPY --from=build /target/spring-boot-2-rest-api.jar spring_boot_2_rest_api.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring_boot_2_rest_api.jar"]
