mvn clean install &&
docker build . -t xbarrelet/springmvc-lettuce-tester &&
docker push xbarrelet/springmvc-lettuce-tester
