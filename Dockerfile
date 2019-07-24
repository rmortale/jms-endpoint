FROM maven:3.6.1-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/*shaded.jar app.jar
CMD ["java", "-jar", "app.jar"]
