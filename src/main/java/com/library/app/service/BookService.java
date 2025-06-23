package com.library.app.service;

import com.library.app.dto.*;

import java.util.List;

public interface BookService {

    SearchBookDto addBook(CreateBookDto createBookDto);

    List<SearchBookDto> listBook();

    SearchBookDto searchBook(String name);

    ViewRentDto rentBook(String name, RentDto rentDto);

    ViewBookDto Book(String name);

    ViewRentDto rent(String name,RentDto rentDto);
}
