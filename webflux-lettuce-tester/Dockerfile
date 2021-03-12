FROM openjdk:15

ADD target/webflux-lettuce-redis-tester.jar /webflux-lettuce-redis-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/webflux-lettuce-redis-tester.jar"]
