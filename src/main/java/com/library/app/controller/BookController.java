package com.library.app.controller;

import com.library.app.apiresponse.ApiResponse;
import com.library.app.dto.*;
import com.library.app.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<SearchBookDto>> registerBook(@Valid @RequestBody CreateBookDto createBookDto) {
        SearchBookDto bookData = bookService.addBook(createBookDto);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Book add to Library", bookData, null));
    }

    @GetMapping("/listbook")
    public ResponseEntity<ApiResponse<List<SearchBookDto>>> listBook() {
        List<SearchBookDto> bookList = bookService.listBook();

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Book add to Library", bookList, null));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<SearchBookDto>> searchBook(@RequestParam String bookname) {
        SearchBookDto bookData = bookService.searchBook(bookname);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Book is found", bookData, null));
    }

    @GetMapping("/rentbook/{bookname}")
    public ResponseEntity<ApiResponse<ViewBookDto>> Book(@PathVariable String bookname) {
        ViewBookDto bookData = bookService.Book(bookname);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Book is for rent", bookData, null));
    }

    @PostMapping("/rentbook/{bookname}")
    public ResponseEntity<ApiResponse<ViewRentDto>> rentBook(@PathVariable String bookname,@Valid @RequestBody RentDto rentDto) {
        ViewRentDto bookData = bookService.rentBook(bookname,rentDto);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "Book is for rent", bookData, null));
    }

    @PostMapping("/rentbook/{bookname}/rent")
    public ResponseEntity<ApiResponse<ViewRentDto>> rent(@PathVariable("bookname") String bookName,@Valid @RequestBody RentDto rentDto) {
        ViewRentDto bookData = bookService.rent(bookName,rentDto);

        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK, "You Have Successfully Rented " +bookData.getBookName() +" Book.", bookData, null));
    }
}