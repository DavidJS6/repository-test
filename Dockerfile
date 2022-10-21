# Docker Build Stage
FROM maven:3-jdk-8-alpine AS build


# Build Stage
WORKDIR /opt/app

COPY ./ /opt/app
RUN mvn clean package -DskipTests


# Docker Build Stage
FROM openjdk:8-jdk-alpine

COPY --from=build /opt/app/target/*.jar repository-test.jar

ENV PORT 8282
EXPOSE $PORT

ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","repository-test.jar"]

