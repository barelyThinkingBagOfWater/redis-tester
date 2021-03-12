FROM openjdk:15

ADD target/quarkus-app /
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/quarkus-run.jar"]
