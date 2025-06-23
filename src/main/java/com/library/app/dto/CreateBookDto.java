package com.library.app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDto {

    @NotBlank(message = "Book name is required")
    private String bookName;

    @NotBlank(message = "Author name is required")
    private String authorName;

    @NotBlank(message = "Publisher is required")
    private String publishedBy;

    @NotNull(message = "Published date is required")
    @PastOrPresent(message = "Published date cannot be in the future")
    private LocalDate publishedDate;

    @Size(max = 1000, message = "Description can't exceed 1000 characters")
    private String bookDescription;

    @NotNull(message = "Book price is required")
    @Positive(message = "Book price must be greater than zero")
    private Double bookPrice;

}
