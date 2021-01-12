FROM openjdk:8-jdk-alpine

COPY ./build/libs/spring-boot-kubernetes-1.0-SNAPSHOT.jar /usr/app/joke-api-1.0.0.jar

WORKDIR /usr/app

EXPOSE 9091

RUN sh -c 'touch joke-api-1.0.0.jar'

ENTRYPOINT ["java", "-jar", "joke-api-1.0.0.jar"]