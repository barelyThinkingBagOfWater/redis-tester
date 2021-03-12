mvn clean install &&
docker build . -t xbarrelet/quarkus-redisson-tester &&
docker push xbarrelet/quarkus-redisson-tester
