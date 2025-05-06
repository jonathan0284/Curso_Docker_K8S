FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-deseos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9084
ENTRYPOINT ["java", "-jar", "app.jar"]