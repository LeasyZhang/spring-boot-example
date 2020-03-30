package com.springboot.example.config;

import com.springboot.example.constant.UploadTaskStatus;
import com.springboot.example.dto.NewUploadTaskDTO;
import com.springboot.example.exception.SQSException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(SQSException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<NewUploadTaskDTO> notFound(SQSException ex) {
        NewUploadTaskDTO uploadTaskDTO = new NewUploadTaskDTO();
        uploadTaskDTO.setMessage("Third party services not available");
        uploadTaskDTO.setStatus(UploadTaskStatus.UPLOAD_FAILED);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(uploadTaskDTO);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<NewUploadTaskDTO> otherError() {
        NewUploadTaskDTO uploadTaskDTO = new NewUploadTaskDTO();
        uploadTaskDTO.setMessage("Internal server error!");
        uploadTaskDTO.setStatus(UploadTaskStatus.UPLOAD_FAILED);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(uploadTaskDTO);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<String> internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error!");
    }
}
