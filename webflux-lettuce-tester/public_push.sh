mvn clean install &&
docker build . -t xbarrelet/webflux-lettuce-tester &&
docker push xbarrelet/webflux-lettuce-tester
