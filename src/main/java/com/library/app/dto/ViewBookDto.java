package com.library.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewBookDto {

    private String bookName;
    private String bookDescription;
    private Double bookPrice;
    private int bookRentalHour;
    private Double totalAmount;

}
