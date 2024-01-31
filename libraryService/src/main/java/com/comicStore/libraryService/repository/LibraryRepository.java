package com.comicStore.libraryService.repository;

import com.comicStore.libraryService.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Library,String> {
    Optional<Library> findByUuid(UUID uuid);
}
