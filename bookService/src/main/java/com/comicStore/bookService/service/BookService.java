package com.comicStore.bookService.service;

import com.comicStore.bookService.dto.BookDto;
import com.comicStore.bookService.dto.BookIdDto;
import com.comicStore.bookService.exception.BookNotFoundException;
import com.comicStore.bookService.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private final RestTemplate restTemplate;

    public BookService(BookRepository bookRepository, RestTemplate restTemplate) {
        this.bookRepository = bookRepository;
        this.restTemplate = restTemplate;
    }
    public List<BookDto> getAllBooks(){
        return bookRepository.findAll().stream().map(BookDto::convertFromBook).toList();
    }
    public BookIdDto findByIsbn(String isbn){
        return bookRepository.getBookByIsbn(isbn).map(book -> new BookIdDto(book.getUuid().toString(),book.getIsbn())).orElseThrow(()->new BookNotFoundException("Book could not found by isbn"+isbn));
    }
    public BookDto findBookDetailsById(String uuid){
        return bookRepository.findByUuid(UUID.fromString(uuid)).map(BookDto::convertFromBook).orElseThrow(()->new BookNotFoundException("Book could not found by id"+uuid));
    }
    public List<BookDto> getBookFromExternalSystem(String superhero){
        Map<String, String> superheroParam = Collections.singletonMap("title", superhero);
        String url = "https://developer.marvel.com/VisualCrossingWebServices/rest/services/timeline/{cityName}?unitGroup=metric&include=current&key=AKW5AX4MWUR6M5P9YPEQA9EQG&contentType=json";
        return new ArrayList<>();
    }
}
