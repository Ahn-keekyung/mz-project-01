FROM openjdk:11-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=build/libs/*jar
COPY ${JAR_FILE} mz-project-01.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mz-project-01.jar"]