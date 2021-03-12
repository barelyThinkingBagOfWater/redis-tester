mvn clean install -Dmaven.test.skip=true && 
	docker build . -t localhost:5000/quarkus-lettuce-tester &&
	docker push localhost:5000/quarkus-lettuce-tester
