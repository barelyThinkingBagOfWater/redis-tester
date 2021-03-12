mvn clean install &&
docker build . -t xbarrelet/springmvc-redisson-tester &&
docker push xbarrelet/springmvc-redisson-tester
