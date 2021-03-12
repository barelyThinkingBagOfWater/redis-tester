mvn clean install &&
docker build . -t xbarrelet/webflux-redisson-tester &&
docker push xbarrelet/webflux-redisson-tester
