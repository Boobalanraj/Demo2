package com.library.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRentDto {

    private String bookName;
    private String bookDescription;
    private Double bookPrice;
    private int bookRentalHour;
    private Double totalAmount;

}
