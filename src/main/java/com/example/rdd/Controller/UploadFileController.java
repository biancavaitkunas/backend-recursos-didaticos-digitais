package com.example.rdd.Controller;

import com.example.rdd.Service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class UploadFileController {

    @Autowired
    private UploadFileService service;

    @PostMapping
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile arquivo) throws Exception {
        service.save(arquivo);
        return ResponseEntity.ok("Imagem salva com sucesso!");
    }
}
