FROM openjdk:15

ADD target/springmvc-lettuce-tester.jar /springmvc-lettuce-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/springmvc-lettuce-tester.jar"]
