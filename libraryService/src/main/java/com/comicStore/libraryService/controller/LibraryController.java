package com.comicStore.libraryService.controller;

import com.comicStore.libraryService.dto.AddBookRequest;
import com.comicStore.libraryService.dto.LibraryDto;
import com.comicStore.libraryService.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
        logger.info("getLibraryById is started by {}",id);
        return ResponseEntity.ok(libraryService.getAllBooksInLibrary(id));
    }
    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(){
        logger.info("createLibrary is started by ");
        return ResponseEntity.ok(libraryService.createLibrary());
    }
    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
        logger.info("addBookToLibrary is started by {}",request.uuid());
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }

}
