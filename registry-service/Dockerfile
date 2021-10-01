FROM openjdk:8-jdk-alpine
LABEL maintainer="tareltos@gmail.com"

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} registry-service.jar

CMD  ["java","-jar","/registry-service.jar"]

EXPOSE 8084

