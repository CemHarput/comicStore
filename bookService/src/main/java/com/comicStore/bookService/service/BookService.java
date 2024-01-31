package com.comicStore.bookService.service;

import com.comicStore.bookService.dto.BookDto;
import com.comicStore.bookService.dto.BookIdDto;
import com.comicStore.bookService.exception.BookNotFoundException;
import com.comicStore.bookService.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookDto> getAllBooks(){
        return bookRepository.findAll().stream().map(BookDto::convertFromBook).collect(Collectors.toList());
    }
    public BookIdDto findByIsbn(String isbn){
        return bookRepository.getBookByIsbn(isbn).map(book -> new BookIdDto(book.getUuid(),book.getIsbn())).orElseThrow(()->new BookNotFoundException("Book could not found by isbn"+isbn));
    }
    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id).map(BookDto::convertFromBook).orElseThrow(()->new BookNotFoundException("Book could not found by id"+id));
    }
}