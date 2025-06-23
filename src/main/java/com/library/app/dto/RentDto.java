package com.library.app.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentDto {

    @Min(value = 1, message = "Book rental hour must be at least 1")
    private int bookRentalHour;

}
