package com.example.boot;

import com.example.boot.uploader.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BootApplication implements CommandLineRunner {

    @Autowired
    private S3Uploader uploader;

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.NONE)
                .build(args)
                .run(BootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String bucketName = "";
        String key = "";
        String from = "";
        String to = "";
        uploader.createBucket(bucketName);
        uploader.upload(bucketName, key, from);
        uploader.download(bucketName, key, to);
        //uploader.delete(bucketName, key);
    }
}
