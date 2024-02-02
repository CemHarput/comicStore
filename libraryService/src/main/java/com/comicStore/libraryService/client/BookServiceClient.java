package com.comicStore.libraryService.client;

import com.comicStore.libraryService.dto.BookDto;
import com.comicStore.libraryService.dto.BookIdDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="book-service",path="/v1/book")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/book/{uuid}")
    ResponseEntity<BookDto> getBookById(@PathVariable String uuid);

    @GetMapping
    ResponseEntity<List<BookDto>> getAllBook();
}
