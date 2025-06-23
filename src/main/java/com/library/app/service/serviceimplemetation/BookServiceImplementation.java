package com.library.app.service.serviceimplemetation;

import com.library.app.dto.*;
import com.library.app.entity.Book;
import com.library.app.entity.BookStatus;
import com.library.app.exception.customexception.BadRequestException;
import com.library.app.repository.BookRepository;
import com.library.app.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapper model_mapper;


    @Override
    public SearchBookDto addBook(CreateBookDto createBookDto) {
        Book book = model_mapper.map(createBookDto, Book.class);
        Book savedBook = bookRepository.save(book);
        return model_mapper.map(savedBook, SearchBookDto.class);
    }

    @Override
    public List<SearchBookDto> listBook() {
        List<Book> listBook = bookRepository.findAll();
//        if(listBook.isEmpty()){
//            throw new BadRequestException("Admin is already Present");
//        }
        return listBook.stream().map(book -> model_mapper.map(book, SearchBookDto.class)).toList();
    }

    @Override
    public SearchBookDto searchBook(String name) {

        Book book = bookRepository.searchByBookName(name).orElseThrow(() -> new BadRequestException("Book is not in Library"));
        return model_mapper.map(book, SearchBookDto.class);
    }

    @Override
    public ViewBookDto Book(String name) {

        Book book = bookRepository.searchByBookName(name).orElseThrow(() -> new BadRequestException("Book is not in Library"));
        book.setTotalAmount(book.getBookPrice() * book.getBookRentalHour());
        return model_mapper.map(book, ViewBookDto.class);
    }

    @Override
    public ViewRentDto rentBook(String name, RentDto rentDto){
        Book book = bookRepository.searchByBookName(name).orElseThrow(() -> new BadRequestException("Book is Not Available"));
        book.setBookRentalHour(rentDto.getBookRentalHour());
        book.setTotalAmount(book.getBookPrice()*rentDto.getBookRentalHour());
        return model_mapper.map(book,ViewRentDto.class);
    }

    @Override
    public ViewRentDto rent(String name,RentDto rentDto){
        Book book = bookRepository.searchByBookName(name).orElseThrow(() -> new BadRequestException("Book is Not Available"));
        if(book.getBookStatus() != BookStatus.AVAILABLE){
            throw new BadRequestException("Currently "+book.getBookName()+" Book is Not Available");
        }
        book.setBookStatus(BookStatus.NOT_AVAILABLE);
        book.setBookRentalHour(rentDto.getBookRentalHour());
        book.setTotalAmount(rentDto.getBookRentalHour() * book.getBookPrice());
        Book savedBook = bookRepository.save(book);
        return model_mapper.map(savedBook,ViewRentDto.class);
    }

}
