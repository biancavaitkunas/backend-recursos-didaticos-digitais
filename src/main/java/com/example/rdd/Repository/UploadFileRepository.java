package com.example.rdd.Repository;

import com.example.rdd.Domain.UploadFile.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {

    UploadFile save(MultipartFile file);
}
