package com.comicStore.bookService.controller;

import com.comicStore.bookService.dto.BookDto;
import com.comicStore.bookService.dto.BookIdDto;
import com.comicStore.bookService.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("v1/book")
@Validated
public class BookController {
    Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBook(){
        logger.info("getAllBook is started.");
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn){
        logger.info("Book requested by isbn: {}", isbn);
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }
    @GetMapping("/book/{uuid}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty String uuid){
        logger.info("getBookById is started by uuid: {}",uuid);
        return ResponseEntity.ok(bookService.findBookDetailsById(uuid));
    }
}
