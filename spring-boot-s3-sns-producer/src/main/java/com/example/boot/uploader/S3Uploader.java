package com.example.boot.uploader;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class S3Uploader {

    private static final Logger logger = LoggerFactory.getLogger(S3Uploader.class);

    private AmazonS3 amazonS3;

    @Autowired
    public S3Uploader(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public void createBucket(String bucketName) {
        if (amazonS3.doesBucketExistV2(bucketName)) {
            logger.warn("Bucket {} already exists", bucketName);
        }
        amazonS3.createBucket(bucketName);
    }

    public void upload(String bucketName, String target, String path) {
        amazonS3.putObject(bucketName, target, new File(path));
    }

    public void delete(String bucketName, String target) {
        amazonS3.deleteObject(bucketName, target);
    }

    public void download(String bucketName, String target, String storePath) throws IOException {
        S3Object object = amazonS3.getObject(bucketName, target);
        S3ObjectInputStream inputStream = object.getObjectContent();
        FileOutputStream outputStream = new FileOutputStream(new File(storePath));
        FileCopyUtils.copy(inputStream, outputStream);
    }

    public void other() {
    }
}
