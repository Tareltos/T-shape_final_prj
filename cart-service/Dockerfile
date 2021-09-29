FROM openjdk:8-jdk-alpine
LABEL maintainer="tareltos@gmail.com"

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} cart-service.jar

CMD  ["java","-jar","/cart-service.jar"]

EXPOSE 8083

