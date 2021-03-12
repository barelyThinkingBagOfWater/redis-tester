FROM openjdk:15

ADD target/mn-lettuce-tester.jar /mn-lettuce-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/mn-lettuce-tester.jar"]
