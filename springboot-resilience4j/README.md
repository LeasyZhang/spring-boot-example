# Getting started

### Run the application

- Start application from the IDE or use

```bash
$ ./gradlew :springboot-resilence4j:bootRun
```

to start the application

- Visit http://localhost:9080/backendA/success to verify the app

## Monitoring with Prometheus and Grafana(Optional)

### Requirements

- Docker installed
- Docker compose installed

### Steps

#### Update configuration file
Update file docker/prometheus.yml, replace ip address in "192.168.31.37:9080" with your own ip:
Run
```bash
$ ifconfig | grep "inet" 
```
and the address after inet is your ip address

#### In the project root folder start Grafana and Prometheus servers.
```bash
docker-compose -f docker-compose.yml up
```

#### Check prometheus server

- Open http://localhost:9090
- Access status -> Targets, both endpoints must be "UP"

#### Configure the Grafana.
     
- Open http://localhost:3000(admin/admin)
- Configure integration with Prometheus
    - Access configuration
    - Add data source
    - Select Prometheus
    - Use url "http://localhost:9090" and access with value "Browser"
- Configure dashboard
    - Access "home"
    - Import dashboard
    - Upload dashboard.json from /docker