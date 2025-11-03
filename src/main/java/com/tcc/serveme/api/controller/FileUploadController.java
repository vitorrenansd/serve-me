package com.tcc.serveme.api.controller;

import com.tcc.serveme.api.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<List<String>> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        try {
            List<String> fileUrls = Arrays.stream(files)
                    .map(file -> {
                        try {
                            return storageService.storeFile(file);
                        } catch (IOException e) {
                            throw new RuntimeException("Failed to store file " + file.getOriginalFilename(), e);
                        }
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(fileUrls);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
