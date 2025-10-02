# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and pom.xml for dependency caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the Spring Boot app (skip tests)
RUN ./mvnw package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/reviewer-0.0.1-SNAPSHOT.jar"]
