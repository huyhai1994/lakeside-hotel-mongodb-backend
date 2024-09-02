package com.codegym.lakesidehotelmongodb.service;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class FirebaseStorageService {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseStorageService.class);
    private final Storage storage;

    @Autowired
    public FirebaseStorageService(Storage storage) {
        this.storage = storage;
        logger.info("Initialized Firebase Storage with provided credentials.");
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        BlobInfo blobInfo = BlobInfo.newBuilder("lake-side-hotel.appspot.com", fileName).build();
        storage.create(blobInfo, file.getBytes());
        logger.info("File uploaded: " + fileName);
        return fileName;
    }
}