### User guide

Springboot-logstash is a project that integrate logstash with Spring Boot framework.
The sample application can will send logs to both stdout and logstash. The logstash is running in a docker container.

### Requirements

- Gradle 5.0
- Docker (Version 2.0.0.0-mac81 (29211))

### Steps to run

- Go to docker/logstash folder, execute
```bash
$ docker-compose build
$ docker-compose up
```
command to start logstash server.

- Go to springboot-logstash project and run BootApplication
you are supposed to see startup logs in both stdout and console.

- visit some endpoint and check the log on logstash console

for example
```bash
$ curl localhost:8080/ting
```