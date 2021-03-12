	kubectl create configmap grafana-provisoned-datasources-configmap --from-file=provisioning/datasources/prometheus.yml &&
	kubectl create configmap grafana-provisoned-dashboards-configmap --from-file=provisioning/dashboards/all.yml --from-file=provisioning/dashboards/jvm-actuator_rev1.json --from-file=provisioning/dashboards/redis_monitoring.json &&
	kubectl create -f deployment.yml &&
    	kubectl create -f service.yml

