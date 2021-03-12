kubectl create -f clusterRole.yml &&
    kubectl create -f service.yml &&
    kubectl create configmap prometheus-config --from-file=prometheus.yml  &&
    kubectl create -f deployment.yml 
