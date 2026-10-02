FROM eclipse-temurin:25-jre

WORKDIR /app

COPY cis-study-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]