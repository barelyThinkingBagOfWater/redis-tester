HOW TO RUN THE TESTS

1. If it hasn't been done once already instantiate the local docker registry (at localhost:5000) : 
docker run -d -p 5000:5000 --name registry registry:2

2. You need to create and save the docker container of the artifacts to test in the docker registry so Kubernetes can fetch it. Run the script push.sh in the artifacts folder to be tested.

3. Once it's done you're ready to instantiate the docker service and Kubernetes cluster

4. Start the redis instance + its metrics exporter by running k8/redis/start.sh script.

5. Start Prometheus that will collect the metrics by running k8/prometheus/start.sh script. 
You can access it by going to localhost:30002 and do some query to consult the metrics.

6. Start Grafana that will display the metrics through dashboard by running k8/grafana/start.sh script.
You can access it by going to localhost:30003, login as admin:admin, skip the password creation page and finding the dashboards through the left pane (4 squares button) -> manage.

7. Now it's time to start the tester itself. Go to k8/tester and first create the configuration and service:
kubectl create -f config.yml
kubectl create -f service.yml

Now start the corresponding deployment.yml to start the tester
kubectl create -f deployment_ARTIFACT.yml


8. Open the load-tester project in your IDE, select the scenario and users you want in the Scenarios file and then run it by right-clicking on Engine -> Run 'Engine'.
The shell opened at the bottom will require your input, 2x Enter to run the test. 

9. You'll find the html file containing the report displayed in the shell, open it in a browser




Useful commands:
kubectl get pods : check the state of each instantiated application on the kubernetes cluster
kubectl describe pod $POD_ID : check the state and details of the pod if a problem occurs
