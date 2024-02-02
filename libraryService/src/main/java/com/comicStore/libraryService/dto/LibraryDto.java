package com.comicStore.libraryService.dto;

import java.util.List;
import java.util.UUID;

public record LibraryDto(String uuid, List<BookDto> userBooks) {
}
