FROM openjdk:8-jdk-alpine
ARG JAR_FILE=$GITHUB_WORKSPACE/build/libs/jarfiles/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]