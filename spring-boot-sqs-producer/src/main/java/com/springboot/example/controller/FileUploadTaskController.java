package com.springboot.example.controller;

import com.springboot.example.constant.UploadTaskStatus;
import com.springboot.example.dto.FileUploadTaskDTO;
import com.springboot.example.dto.NewUploadTaskDTO;
import com.springboot.example.service.FileUploadTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadTaskController {

    private FileUploadTaskService fileUploadTaskService;

    @Autowired
    public FileUploadTaskController(FileUploadTaskService fileUploadTaskService) {
        this.fileUploadTaskService = fileUploadTaskService;
    }

    @PostMapping(value = "/fileUploadTask")
    public ResponseEntity<NewUploadTaskDTO> newTask(@RequestBody FileUploadTaskDTO newTask) {
        NewUploadTaskDTO result = fileUploadTaskService.createFileUploadTask(newTask);
        if (UploadTaskStatus.UPLOAD_SUCCESS.equals(result.getStatus())) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
}
