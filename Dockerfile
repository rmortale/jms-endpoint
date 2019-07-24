FROM maven:3.6.1-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY config.yml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

FROM openjdk:8-jre-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/target/jms-endpoint-1.0.1.jar app.jar
COPY --from=MAVEN_TOOL_CHAIN /tmp/config.yml config.yml
ENTRYPOINT ["java", "-jar", "app.jar"]

CMD ["server", "config.yml"]
