package com.library.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBookDto {

    private Long bookId;
    private String bookName;
    private String authorName;
    private String publishedBy;
    private LocalDate publishedDate;

    public String getPublishedDate() {
        return publishedDate.format(DateTimeFormatter.ofPattern("MMMM dd, YYYY"));
    }
}
