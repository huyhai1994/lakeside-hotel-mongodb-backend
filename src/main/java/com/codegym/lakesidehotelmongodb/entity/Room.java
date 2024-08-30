package com.codegym.lakesidehotelmongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String roomType;
    private String roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    @DBRef
    private List<Booking> bookings = new ArrayList<>();

    public String toString() {
        return "Room{" + "id='" + id + '\'' + ", roomType='" + roomType + '\'' + ", roomPrice='" + roomPrice + '\'' + ", roomPhotoUrl='" + roomPhotoUrl + '\'' + ", roomDescription='" + roomDescription + '\'' + '}';
    }

}
