########
# Dockerfile to build test-service container image
#
########
FROM openjdk:17-slim

LABEL maintainer="Petrulin Alexander"

COPY target/test-service-*.jar app.jar

EXPOSE 8000

ENTRYPOINT ["java","-jar","/app.jar"]
