# Experiments with Spring Boot

The code in this repository is influenced by the work of others:

* [Spring Spock Docker Integration](http://www.frommknecht.net/spring-spock-docker-integration/)
* many more

## groovy-gradle (Not working!)

Language for Application: Groovy
Persistence: MongoDB
Integration Tests: Spock
Database Instance: Docker
Build Tool: Gradle

## groovy-security-gradle (Not working!)

Language for Application: Groovy
Persistence: Gorm
Integration Tests: Spock
Database Instance: HSQLDB
Build Tool: Gradle

```Could not find io.projectreactor:reactor-stream:2.0.0.RELEASE.
Searched in the following locations:
    https://repo1.maven.org/maven2/io/projectreactor/reactor-stream/2.0.0.RELEASE/reactor-stream-2.0.0.RELEASE.pom
    https://repo1.maven.org/maven2/io/projectreactor/reactor-stream/2.0.0.RELEASE/reactor-stream-2.0.0.RELEASE.jar
    https://jcenter.bintray.com/io/projectreactor/reactor-stream/2.0.0.RELEASE/reactor-stream-2.0.0.RELEASE.pom
    https://jcenter.bintray.com/io/projectreactor/reactor-stream/2.0.0.RELEASE/reactor-stream-2.0.0.RELEASE.jar
Required by:
    mr.f:groovy-security-gradle:1.0 > org.grails:gorm-hibernate4-spring-boot:1.0.0.RELEASE > org.grails:grails-datastore-gorm-hibernate4:3.1.0.RELEASE > org.grails:grails-datastore-gorm-hibernate-core:3.1.0.RELEASE > org.grails:grails-async:3.0.1
18:02:42: External task execution finished 'build'.```

## java-gradle

Language for Application: Java
Persistence: Hibernate
Integration Tests: Spock
Database Instance: HSQLDB
Build Tool: Gradle

[Spring Boot](http://projects.spring.io/spring-boot/) application with [JUnit](http://junit.org/) unit tests and [Spock](https://code.google.com/p/spock/) integration tests.

## java-maven (Not working!)

Language for Application: Java
Persistence: Hibernate
Integration Tests: Spock
Database Instance: HSQLDB
Build Tool: Maven (Tomcat Plugin)

## spring-data-rest-angular

Taken from this [Tutorial](http://www.programming-free.com/2014/07/spring-data-rest-with-angularjs-crud.html).

Language for Application: Java
Persistence: Hibernate
Database Instance: MySQL
Build Tool: Maven (Tomcat Plugin)

Link to app after start: http://localhost:8080/home

## java-rest-repo

Language for Application: Java
Persistence: Hibernate
Functional Tests: JUnit
Database Instance: H2 (InMemory)
Build Tool: Gradle

### Interaction

#### Find all entries 

```curl http://localhost:8082/rest/demoResources```

#### Create new entry 

```curl -i -X POST -H "Content-Type:application/json" -d '{  "content" : "blabla" }' http://localhost:8082/rest/demoResources```

#### Search entry

```curl http://localhost:8082/rest/demoResources/search/findByContent?content=SOME_CONTENT```
