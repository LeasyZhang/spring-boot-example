package com.springboot.example.service;

import com.google.gson.Gson;
import com.springboot.example.constant.UploadTaskStatus;
import com.springboot.example.dto.FileUploadTaskDTO;
import com.springboot.example.dto.NewUploadTaskDTO;
import com.springboot.example.dto.UploadFileMetaMessage;
import com.springboot.example.exception.SQSException;
import com.springboot.example.model.UploadFileMeta;
import com.springboot.example.repository.UploadFileMetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class FileUploadTaskService {

    private UploadFileMetaRepository uploadFileMetaRepository;

    private MessageProducer messageProducer;

    @Autowired
    public FileUploadTaskService(UploadFileMetaRepository uploadFileMetaRepository,
                                 MessageProducer messageProducer) {
        this.uploadFileMetaRepository = uploadFileMetaRepository;
        this.messageProducer = messageProducer;
    }

    public NewUploadTaskDTO createFileUploadTask(FileUploadTaskDTO fileUploadTaskDTO) {
        UploadFileMeta uploadFileMeta = buildUploadFileMeta(fileUploadTaskDTO);
        try {
            UploadFileMeta newTask = uploadFileMetaRepository.save(uploadFileMeta);
            UploadFileMetaMessage message = buildFileUploadMetaMessage(newTask);
            String messageToSend = new Gson().toJson(message);
            messageProducer.send(messageToSend);
            NewUploadTaskDTO newTaskStatus = new NewUploadTaskDTO();
            newTaskStatus.setMessage("Create task success");
            newTaskStatus.setStatus(UploadTaskStatus.UPLOAD_SUCCESS);
            return newTaskStatus;
        } catch (SQSException e) {
            throw new SQSException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private UploadFileMeta buildUploadFileMeta(FileUploadTaskDTO fileUploadTaskDTO) {
        UploadFileMeta uploadFileMeta = new UploadFileMeta();
        uploadFileMeta.setFileSize(fileUploadTaskDTO.getFileSize());
        uploadFileMeta.setCreatedTime(Instant.now());
        uploadFileMeta.setUpdatedTime(Instant.now());
        uploadFileMeta.setUploadUrl(fileUploadTaskDTO.getUploadUrl());
        uploadFileMeta.setFileUniqueId(UUID.randomUUID().toString());
        return uploadFileMeta;
    }

    private UploadFileMetaMessage buildFileUploadMetaMessage(UploadFileMeta uploadFileMeta) {
        UploadFileMetaMessage message = new UploadFileMetaMessage();
        BeanUtils.copyProperties(uploadFileMeta, message);
        return message;
    }
}
