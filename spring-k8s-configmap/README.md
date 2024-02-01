# Project Description
This project for Spring Boot is to learn, implement and test, how configmap data is picked by SB application

# Getting Started

**Step 1)** Go to root folder of this project

    cd spring-k8s-configmap

**Step 2)** Build this maven project

    mvn clean package

**Step 3)** Build the docker images in Docker Desktop or minikube

    docker build -t spring-k8s-configmap:0.0.1 .

**Step 4)** Run below commands to delete and apply configmap, service and deployment

    kubectl delete configmap spring-k8s-configapp
    kubectl delete -f k8s-files/spring-k8s-configapp-deployment.yaml

    kubectl apply -f k8s-files/spring-k8s-configapp-servicerole.yml
    kubectl apply -f k8s-files/spring-k8s-configapp-configmap.yaml
    kubectl apply -f k8s-files/spring-k8s-configapp-deployment.yaml
    
    kubectl expose deployment spring-k8s-configmap --type=LoadBalancer --name=my-service
    
**Step 5)** Browse GET api to get and check if config loaded from configmap

    curl -v http://localhost:8080/api/config/all
    
**Step 6)** Clean up all resources

    kubectl delete -f k8s-files/spring-k8s-configapp-deployment.yaml
    kubectl delete -f k8s-files/spring-k8s-configapp-servicerole.yml
    kubectl delete configmap spring-k8s-configapp -n ns-sample
    kubectl delete service my-service -n ns-sample


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#actuator)
* [Cloud Bootstrap](https://docs.spring.io/spring-cloud-commons/docs/current/reference/html/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [https://www.baeldung.com/spring-cloud-kubernetes](https://www.baeldung.com/spring-cloud-kubernetes)
* [https://stackoverflow.com/questions/54649401/kubernetes-how-to-create-and-use-configmap-from-multiple-files](https://stackoverflow.com/questions/54649401/kubernetes-how-to-create-and-use-configmap-from-multiple-files)
* [https://stackoverflow.com/questions/49287078/how-to-merge-two-configmaps-using-volume-mount-in-kubernetes](https://stackoverflow.com/questions/49287078/how-to-merge-two-configmaps-using-volume-mount-in-kubernetes)
