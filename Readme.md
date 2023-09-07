# 9TH BIT FITCamel Quarkus Example

Example project to demonstrate 9TH BIT VETRO pattern implementations running on Quarkus. The diagram shows the simple implementation.

![Camel Routes](img/camel-routes.png)


Use the following commands to build and run the application:

      mvn clean install
      cd target/quarkus-app
      java -jar quarkus-run.jar


Use the following commands to build and run the application in a container. You will need a system 
with *buildah* and *podman* to build and run the container:

      mvn clean install -Poci-image,test
      podman run -it --rm -p 8080:8080 localhost/acme-person:1.0-SNAPSHOT


Run the following curl command to call the service:

      curl -X POST -H "Content-Type: application/json" -H "Accept: application/json"  http://localhost:8080/person -d '{"id":"1","firstName":"Piet","lastName":"Pompies"}'

Run the following curl commands to call the health checks:

      curl http://localhost:8080/q/health/ready
      curl http://localhost:8080/q/health/live
