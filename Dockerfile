# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy source code
COPY src ./src

# Make mvnw executable
RUN chmod +x mvnw

# Build project (skip tests for faster build)
RUN ./mvnw package -DskipTests

# Expose the port for Render
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/reviewer-0.0.1-SNAPSHOT.jar"]
