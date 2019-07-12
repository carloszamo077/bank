## Java Spring
Bank example app

### Table of Contents
* [Requirements](#requirements)
* [Run](#run)
* [Endpoints](#endpoints)

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
* Health endpoint: `<host>:<port>/<contextRoot>/health`
* Metrics endpoint: `<host>:<port>/<contextRoot>/metrics`
* Accounts endpoint: `<host>:<port>/<contextRoot>/api/accounts/`
* Cards endpoint: `<host>:<port>/<contextRoot>/api/cards/`
* Transfers endpoint: `<host>:<port>/<contextRoot>/api/transfers/`
* Public endpoint: `<host>:<port>/<contextRoot>/api/public/`
<<<<<<< Updated upstream
* Authenticate endpoint: `<host>:<port>/<contextRoot>/api/authenticate?username=carlos&password=carlos`
=======
* Authenticate endpoint: POST `<host>:<port>/<contextRoot>/api/authenticate?username=carlos&password=carlos`

### Configuration

keytool -genkey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -validity 4000 -keysize 2048

>>>>>>> Stashed changes
