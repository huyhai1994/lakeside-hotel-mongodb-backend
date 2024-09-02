package com.codegym.lakesidehotelmongodb.controller;

import com.google.cloud.storage.Blob;
import com.google.firebase.cloud.StorageClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Generate a unique file name using UUID
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

            Blob blob = StorageClient.getInstance().bucket().create(fileName, file.getInputStream(), file.getContentType());

            String fileUrl = String.format("https://storage.googleapis.com/%s/%s", blob.getBucket(), blob.getName());            // Return a success response with the uploaded file name

            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            // In case of an error, print the stack trace and return an error response
            e.printStackTrace();
            return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}