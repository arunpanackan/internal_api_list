# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Print Working Directory
RUN pwd

# Copy pom.xml and package
COPY pom.xml .
RUN mvn clean package
COPY . .

# List Files in Directory
RUN ls -l /app

# Print Contents of pom.xml
RUN cat pom.xml

# Print Environment Variables
RUN echo "JAVA_HOME is $JAVA_HOME"

# Print Maven Version
RUN mvn --version

# Run Maven in Debug Mode
RUN mvn clean package -X

# Production stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

RUN ls -l /app

# Copy built JAR from the build stage
COPY --from=build /app/target/internal_app-0.0.1-SNAPSHOT.jar /app/target/internal_app.jar


# List Contents of target directory
RUN ls -l /app
RUN ls -l /app/target


# Expose port
EXPOSE 8080

# Entry point
ENTRYPOINT ["java", "-jar", "/app/target/internal_app.jar"]
