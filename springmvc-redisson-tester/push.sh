mvn clean install -Dmaven.test.skip=true && 
	docker build . -t localhost:5000/springmvc-redisson-tester &&
	docker push localhost:5000/springmvc-redisson-tester
