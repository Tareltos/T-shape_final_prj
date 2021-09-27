FROM openjdk:8-jdk-alpine
LABEL maintainer="tareltos@gmail.com"

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} order-service.jar

CMD  ["java","-jar","/order-service.jar"]

EXPOSE 8080

