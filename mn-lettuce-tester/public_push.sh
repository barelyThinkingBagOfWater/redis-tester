mvn clean install &&
docker build . -t xbarrelet/mn-lettuce-tester &&
docker push xbarrelet/mn-lettuce-tester
