FROM openjdk:21-ea-19-jdk-bullseye

WORKDIR /app

COPY target/microservice-1.0.0.jar ./app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]

