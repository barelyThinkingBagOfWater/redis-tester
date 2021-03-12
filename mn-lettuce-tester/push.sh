mvn clean install -Dmaven.test.skip=true && 
	docker build . -t localhost:5000/mn-lettuce-tester &&
	docker push localhost:5000/mn-lettuce-tester
