FROM openjdk:8
COPY target/soap-service.jar soap-service.jar
ENTRYPOINT ["java","-jar","soap-service.jar"]
EXPOSE 8080
