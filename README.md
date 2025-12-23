# library-demo

## Goal

 - Demonstrate how to generate arbitrary documentation from your application
 - Additionally, show how to use [Hibernate Data Repositories](https://docs.hibernate.org/orm/7.1/repositories/html_single/)

## Requirements

 - Java 21
 - Docker for booting mySQL

## Run

    mvn jooby:run

## Output:

 - http://localhost:8080/docs
 - http://localhost:8080/docs/full.html
 - http://localhost:8080/docs/tryIt.html

 - http://localhost:8080/redoc
 - http://localhost:8080/swagger

## Documentation and usage

 - https://jooby.io/modules/openapi
 - https://jooby.io/modules/openapi/#openapi-outputdisplay

