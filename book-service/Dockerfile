FROM openjdk:8-jdk-alpine
LABEL maintainer="tareltos@gmail.com"

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} book-service.jar

CMD  ["java","-jar","/book-service.jar"]

EXPOSE 8081

