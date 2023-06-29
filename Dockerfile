
FROM eclipse-temurin:17-jdk-alpine
MAINTAINER yugeshae@gmail.com
COPY target/Spring_Boot_2_Rest_API-0.0.1-SNAPSHOT.jar Spring_Boot_2_Rest_API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Spring_Boot_2_Rest_API-0.0.1-SNAPSHOT.jar"]