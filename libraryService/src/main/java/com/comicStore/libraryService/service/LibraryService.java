package com.comicStore.libraryService.service;

import com.comicStore.libraryService.client.BookServiceClient;
import com.comicStore.libraryService.dto.AddBookRequest;
import com.comicStore.libraryService.dto.LibraryDto;
import com.comicStore.libraryService.exception.LibraryNotFoundException;
import com.comicStore.libraryService.model.Library;
import com.comicStore.libraryService.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;


@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }
    public LibraryDto getAllBooksInLibrary(String id){
       Library library = libraryRepository.findByUuid(UUID.fromString(id)).orElseThrow(()->new LibraryNotFoundException("Library could not found : "+id));

       return new LibraryDto(library.getUuid().toString(),
                library.getUserBooks()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .toList());
    }
    public LibraryDto createLibrary(){
        Library library = libraryRepository.save(new Library());
        return new LibraryDto(library.getUuid().toString(),null);
    }
    public void addBookToLibrary(AddBookRequest request){
        String bookId = String.valueOf(Objects.requireNonNull(bookServiceClient.getBookByIsbn(request.isbn()).getBody()).uuid());
        UUID libraryId = UUID.fromString(request.uuid());
        Library library = libraryRepository.findByUuid(libraryId).orElseThrow(()-> new LibraryNotFoundException("Library could not found "+request.uuid()));

        library.getUserBooks().add(bookId);
        libraryRepository.save(library);
    }
}
