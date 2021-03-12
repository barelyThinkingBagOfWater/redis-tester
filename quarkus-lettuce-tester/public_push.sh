mvn clean install &&
docker build . -t xbarrelet/quarkus-lettuce-tester &&
docker push xbarrelet/quarkus-lettuce-tester
