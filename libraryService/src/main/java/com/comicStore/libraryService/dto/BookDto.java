package com.comicStore.libraryService.dto;

import java.util.Date;
import java.util.UUID;

public record BookDto(UUID uuid, int id, int digitalId, String title, int issueNumber, String variantDescription, String description,
                      Date modified, String isbn, String upc, String diamondCode, String ean, String issn, String format, int pageCount) {


}
