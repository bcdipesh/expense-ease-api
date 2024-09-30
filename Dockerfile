#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn -Pnative native:compile -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/expense-ease-api-0.0.1-SNAPSHOT.jar expense-ease-api.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "expense-ease-api.jar"]

# Using Oracle GraalVM
FROM container-registry.oracle.com/graalvm/native-image:21-ol8 AS builder

# Install locale and gzip
RUN microdnf install -y glibc-locale-source glibc-langpack-en gzip

# Set locale to en_US.UTF-8
RUN localedef -i en_US -f UTF-8 en_US.UTF-8
ENV LANG=en_US.UTF-8

# Set the working directory to /build
WORKDIR /build

# Copy the source code into the image for building
COPY . /build

# Build
RUN ./mvnw --no-transfer-progress native:compile -Pnative -DskipTests

# The deployment Image
FROM container-registry.oracle.com/os/oraclelinux:8-slim

EXPOSE 8080

# Copy the native executable into the container
COPY --from=builder /build/target/expense-ease-api /app

ENTRYPOINT ["/app"]
