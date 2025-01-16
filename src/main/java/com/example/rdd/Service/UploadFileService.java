package com.example.rdd.Service;

import com.example.rdd.Domain.UploadFile.UploadFile;
import com.example.rdd.Repository.UploadFileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class UploadFileService extends GenericService<UploadFile, Long> {

    @Autowired
    private UploadFileRepository repository;

    @Transactional
    public UploadFile save(final MultipartFile arquivo) throws IOException {
        final var file = UploadFile.builder().description(arquivo.getOriginalFilename()).image(arquivo.getBytes()).build();
        repository.save(file);
        return file;
    }

}
