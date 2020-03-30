package com.springboot.example.repository;

import com.springboot.example.model.UploadFileMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UploadFileMetaRepository extends JpaRepository<UploadFileMeta, Long> {

    Optional<UploadFileMeta> findFirstByFileUniqueId(String fileUniqueId);
}
