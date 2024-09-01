package com.codegym.lakesidehotelmongodb.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setStorageBucket("lake-side-hotel.appspot.com").build();

        return FirebaseApp.initializeApp(options);
    }

    @Bean
    public Storage storage() throws IOException {
        return StorageOptions.getDefaultInstance().getService();
    }
}