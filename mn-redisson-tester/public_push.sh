mvn clean install &&
docker build . -t xbarrelet/mn-redisson-tester &&
docker push xbarrelet/mn-redisson-tester
