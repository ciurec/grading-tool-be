FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/grading-0.0.1-SNAPSHOT.jar backend.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "backend.jar"]
