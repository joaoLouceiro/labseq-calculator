# Labseq Calculator

The labseq-calculator is a simple RESTful web service that calculates the nth number in the Labseq sequence, defined as follows:

$$
\begin{equation}
l(n)=
\begin{cases}
 0 & \text{if } n=0 & \lor & n=2\\
 1 & \text{if } n=1 & \lor & n=3\\
 l(n-4) + l(n-3) & \text{if } n>3 \\
\end{cases}
\end{equation}
$$

It is built using Quarkus, a modern Java framework designed for building high-performance applications.

---

- [Requirements](#requirements)
- [Running the application](#running-the-application)
  - [Running with Maven or the Quarkus CLI](#maven-and-quarkus-cli)
  - [Running with Docker](#docker)
  - [Running the tests](#running-the-tests)
- [Using the service](#using-the-service)
- [OpenAPI and Swagger](#openapi-and-swagger)

## Requirements

- Java 25
- Maven
- Docker
- Quarkus CLI (optional)

## Running the application

### Maven and Quarkus CLI

To run the application in development mode (enabling fast-reloading), `cd` into the root folder and run:

```sh
./mvnw quarkus:dev
```

If you have the Quarkus CLI tool (highly recommended), you can simply run:

```sh
quarkus dev
```

To run the tests, run

```sh
./mvnw quarkus:test
```

You can also run the tests using the Quarkus CLI:

```sh
quarkus test
```

### Docker


#### 1. Start by packaging the service using

```sh
./mvnw package
```

#### 2. Build it with Docker

```sh
docker build labseq-calculator .
```

#### 3. Run it with Docker

```sh
docker run -i --rm -p 8080:8080 labseq-calculator
```

## Using the service

The main interaction with the service is through the `/labseq/<n>` endpoint, where `n` is any **non-negative number**.

Try it out with the following link (the application should be served in port `8080`):
[http://localhost:8080/labseq/100](http://localhost:8080/labseq/100)

## OpenAPI and Swagger

The application is OpenAPI compliant and has a Swagger portal available.

To download the OpenAPI specification, visit
http://localhost:8080/swagger

To open the Swagger UI, go to http://localhost:8080/q/swagger-ui