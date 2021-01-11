FROM java:8-jdk-alpine

COPY ./target/joke-api-1.0.0.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch joke-api-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "joke-api-1.0.0.jar"]