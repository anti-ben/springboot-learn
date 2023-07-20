FROM openjdk:11-jdk-alpine AS builder
ARG WORK_PATH="/app"
WORKDIR $WORK_PATH
COPY . .
RUN ./gradlew clean build -x test

FROM openjdk:11-jdk-alpine
ARG EXPOSE_PORT=8080
WORKDIR $WORK_PATH
COPY --from=builder /api/build/libs/api.jar app.jar
EXPOSE $EXPOSE_PORT
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
