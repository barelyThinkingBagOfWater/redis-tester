FROM openjdk:15

ADD target/springmvc-redisson-tester.jar /springmvc-redisson-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/springmvc-redisson-tester.jar"]
