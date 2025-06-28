FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
# Use offical JDK image

FROM eclipse-temurin:21-jdk-alpine

# Set working dir

WORKDIR /app

# Copy JAR to container
COPY --from=builder /app/target/*.jar app.jar

# Expose spirngboot port
EXPOSE 8080

# Run application
ENTRYPOINT ["java","-jar","app.jar"]