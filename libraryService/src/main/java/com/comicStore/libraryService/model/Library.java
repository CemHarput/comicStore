package com.comicStore.libraryService.model;


import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Library {

    @Id
    @Column(name="library_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ElementCollection
    private List<String> userBooks;

    public Library() {
    }

    public Library(UUID uuid, List<String> userBooks) {
        this.uuid = uuid;
        this.userBooks = userBooks;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
    public List<String> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<String> userBooks) {
        this.userBooks = userBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return Objects.equals(uuid, library.uuid) && Objects.equals(getUserBooks(), library.getUserBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, getUserBooks());
    }
}
