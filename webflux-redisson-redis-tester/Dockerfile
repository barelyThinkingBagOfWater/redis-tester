FROM openjdk:15

ADD target/webflux-redisson-redis-tester.jar /webflux-redisson-redis-tester.jar
ENTRYPOINT ["java","-jar","-XX:MaxRAMPercentage=75","/webflux-redisson-redis-tester.jar"]
