FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-citas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]