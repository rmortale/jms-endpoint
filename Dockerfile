FROM maven:3.6.1-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:3.6.1-jdk-8-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*.jar /app.jar
CMD ["java", "-jar", "app.jar"]
