# Stockify Server

Stockify Server will handle all things stocks.

## Stack

The Stockify Server is built on top of a few core technologies:

* Java 21
* [Maven](https://maven.apache.org) (3.0.0+)
* [Spring Boot](https://spring.io/projects/spring-boot)

## Build

To build the Stockify Server without running tests:

`mvn clean compile`

To build the Stockify Server and run tests:

`mvn clean test`

To build the Stockify Server and generate code coverage:

`mvn clean verify`

## Environment

In order to run the Stockify Server the following environmental variables must be set:

| VARIABLE                    | Description                                                                       |
|:----------------------------|:----------------------------------------------------------------------------------|

## Health Check
To verify the app is up and running you can call the health endpoint below

### Health Check Endpoint

| Method | Url                  | Description                                      |
|:-------|:---------------------|:-------------------------------------------------|
| GET    | .../actuator/health/ | Returns `up` or `down` status of the application |
