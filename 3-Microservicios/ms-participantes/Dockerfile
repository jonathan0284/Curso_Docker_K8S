FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-participantes-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7075
ENTRYPOINT ["java", "-jar", "app.jar"]