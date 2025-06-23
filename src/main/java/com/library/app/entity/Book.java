package com.library.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String authorName;
    private String publishedBy;
    private LocalDate publishedDate;
    private String bookDescription;
    private Double bookPrice;
    private int bookRentalHour = 15;
    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus = BookStatus.AVAILABLE;

}
