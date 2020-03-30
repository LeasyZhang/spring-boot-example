package com.springboot.example.dto;

import com.springboot.example.constant.UploadTaskStatus;

public class NewUploadTaskDTO {

    private UploadTaskStatus status;
    private String message;

    public UploadTaskStatus getStatus() {
        return status;
    }

    public void setStatus(UploadTaskStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
