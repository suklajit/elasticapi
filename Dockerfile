# Use OpenJDK 8 base image
FROM eclipse-temurin:8-jdk

# Set default Spring profile (can be overridden at runtime)
ENV env_profile=default

# Create application directory
RUN mkdir -p /app

# Copy the packaged jar file into the container
COPY ./target/elasticsearch-1.0.0.jar /app/app.jar

# Expose port 8080
EXPOSE 8080

# Use a shell script to support dynamic profiles
ENTRYPOINT sh -c "java -jar /app/app.jar --spring.profiles.active=${env_profile}"
