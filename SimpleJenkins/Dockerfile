
# Use Maven with OpenJDK 21 for building
FROM maven:3.9.6-eclipse-temurin-22-alpine AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml .

# Download dependencies (this layer will be cached unless pom.xml changes)
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use OpenJDK 21 runtime for the final image
FROM openjdk:21-ea-1-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar from the build stage
COPY --from=build /app/target/SimpleJenkins-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on (default 8080)
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "app.jar"]
