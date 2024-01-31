package com.comicStore.bookService.dto;

import java.util.UUID;

public record BookIdDto(UUID uuid, String isbn) {
}
