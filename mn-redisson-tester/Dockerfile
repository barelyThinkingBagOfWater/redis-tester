FROM openjdk:15

ADD target/mn-redisson-tester.jar /mn-redisson-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/mn-redisson-tester.jar"]
