package com.comicStore.bookService.repository;

import com.comicStore.bookService.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book,String> {

    Optional<Book> getBookByIsbn(String isbn);
    Optional<Book> findByUuid(UUID uuid);
}
