## Java Spring
Bank example app

### Table of Contents
* [Requirements](#requirements)
* [Run](#run)
* [Endpoints](#endpoints)
* [H2](#h2)

### Requirements
* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

### Run

* Build Spring Boot Project with Maven

1. `mvn package`
2. `mvn install`

* Run Spring Boot app with java -jar command

1. `java -jar bank-0.0.1-SNAPSHOT.jar`

* Run Spring Boot app using Maven

1. `mvn spring-boot:run`

* Run spring boot application in intellij

    * [Intellij](https://www.jetbrains.com/help/idea/spring-boot.html)

### Endpoints

The application exposes the following endpoints:
* H2 Console endpoint: `<host>:<port>/<contextRoot>/h2-console`
* Swagger endpoint: `<host>:<port>/<contextRoot>/v2/api-docs`
* Actuator endpoint: `<host>:<port>/<contextRoot>/actuator`
* Health endpoint: `<host>:<port>/<contextRoot>/health`
* Metrics endpoint: `<host>:<port>/<contextRoot>/metrics`
* Accounts endpoint: `<host>:<port>/<contextRoot>/v1/api/accounts/`
* Cards endpoint: `<host>:<port>/<contextRoot>/v1/api/cards/`
* Transfers endpoint: `<host>:<port>/<contextRoot>/v1/api/transfers/`
* Public endpoint: `<host>:<port>/<contextRoot>/api/public/`
* Authenticate endpoint: POST `<host>:<port>/<contextRoot>/api/authenticate?username=carlos&password=carlos`

### Configuration

keytool -genkey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -validity 4000 -keysize 2048

### H2

`Generic H2 (Embedded)`
`jdbc:h2:mem:testdb`
