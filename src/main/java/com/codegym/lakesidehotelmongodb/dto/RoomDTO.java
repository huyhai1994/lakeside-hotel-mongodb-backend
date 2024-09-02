package com.codegym.lakesidehotelmongodb.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RoomDTO {
    private String id;
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<BookingDTO> bookings;
}