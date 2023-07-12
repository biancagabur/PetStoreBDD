
# PetStoreBDD testing

In this project I am testing a local copy of [Swagger PetStore API v3](https://petstore3.swagger.io/) using [Cucumber](https://cucumber.io/) and [RESTassured](https://rest-assured.io/).

To create the local copy, I am using [Docker](https://www.docker.com/)
```
docker run --name petstore -d -p 12345:8080 swaggerapi/petstore3:unstable
```

## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean test
