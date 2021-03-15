mvn clean install -Dmaven.test.skip=true &&
mvn package -Pnative -Dmaven.test.skip=true &&
	docker build . -f Dockerfile_native -t localhost:5000/quarkus-lettuce-tester &&
	docker push localhost:5000/quarkus-lettuce-tester
