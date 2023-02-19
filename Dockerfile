FROM openjdk:8-jdk-alpine
COPY target/AuthorizationApp-0.0.1-SNAPSHOT.jar AuthorizationApp.jar
EXPOSE 8080
CMD ["java", "-jar", "authorizationapp.jar"]