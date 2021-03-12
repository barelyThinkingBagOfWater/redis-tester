mvn clean install -Dmaven.test.skip=true && docker build . -t webflux-lettuce-tester && docker run --rm --network isolatedNetwork --name tester -p 8080:80 webflux-lettuce-tester  

