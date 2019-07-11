## Java Spring
Bank example app

### Table of Contents
* [Requirements](#requirements)
* [Run](#run)
* [Endpoints](#endpoints)
* [Configuration](#configuration)

### Requirements
* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](http://www.ibm.com/developerworks/java/jdk/),
    or [Download a Liberty server package](https://developer.ibm.com/assets/wasdev/#filter/assetTypeFilters=PRODUCT)
    that contains the IBM JDK (Windows, Linux)

### Run

* Build Spring Boot Project with Maven

1. `mvn package`
2. `mvn install`

* Run Spring Boot app with java -jar command

1. `java -jar bank-0.0.1-SNAPSHOT.jar`

    * Run dev: java -jar -Dspring.profiles.active=dev target\bank-0.0.1-SNAPSHOT.jar

* Run Spring Boot app using Maven

1. `mvn spring-boot:run`

* Run spring boot application in intellij

    * [Intellij](https://www.jetbrains.com/help/idea/spring-boot.html)

### Endpoints

The application exposes the following endpoints:
* Health endpoint: `<host>:<port>/<contextRoot>/health`
* Metrics endpoint: `<host>:<port>/<contextRoot>/metrics`
* Mappings endpoint: `<host>:<port>/<contextRoot>/mappings`
* Accounts endpoint: `<host>:<port>/<contextRoot>/api/accounts/`
* Cards endpoint: `<host>:<port>/<contextRoot>/api/cards/`
* Transfers endpoint: `<host>:<port>/<contextRoot>/api/transfers/`
* Public endpoint: `<host>:<port>/<contextRoot>/api/public/`
* Authenticate endpoint: `<host>:<port>/<contextRoot>/api/authenticate?username=carlos&password=carlos`

### Configuration

keytool -genkey -keyalg RSA -alias linkedin -keystore keystore.jks -storepass password -validity 4000 -keysize 2048

