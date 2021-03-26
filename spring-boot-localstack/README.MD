# How to run the application

- Go to src/docker and execute

```shell script
docker-compose up -d
```

- go to src/script folder and create the queue by execute

```shell script
sh create_queue.sh
``` 

- Run the application
- After application started, go to src/script folder and listen to the message by execute

```shell script
sh listen_queue.sh
```
