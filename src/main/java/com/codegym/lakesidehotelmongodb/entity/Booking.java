package com.codegym.lakesidehotelmongodb.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Document(collection = "bookings")
public class Booking {
    private String id;
    @NotBlank(message = "Check in date is required")
    private LocalDate checkInDate;

    @NotBlank(message = "Check out date is required")
    private LocalDate checkOutDate;

    @Min(value = 1, message = "Number of adults should not be less than one")
    private int numOfAdults;

    @Min(value = 0, message = "Number of children should not be less than zero")
    private int numOfChildren;

    private int totalNumOfGuest;

    private String bookingConfirmationCode;

    @DBRef
    private User user;

    @DBRef
    private Room room;

    public void calculateTotalNumOfGuest() {
        totalNumOfGuest = numOfAdults + numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumOfGuest();
    }
}
