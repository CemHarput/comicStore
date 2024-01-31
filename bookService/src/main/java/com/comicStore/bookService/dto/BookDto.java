package com.comicStore.bookService.dto;

import com.comicStore.bookService.model.Book;

import java.util.Date;

public record BookDto(int id,int digitalId,String title,int issueNumber,String variantDescription,String description,Date modified,String isbn,String upc,String diamondCode,String ean,String issn,String format,int pageCount) {
    public static BookDto convertFromBook(Book book) {
        return new BookDto(
                book.getId(),
                book.getDigitalId(),
                book.getTitle(),
                book.getIssueNumber(),
                book.getVariantDescription(),
                book.getDescription(),
                book.getModified(),
                book.getIsbn(),
                book.getUpc(),
                book.getDiamondCode(),
                book.getEan(),
                book.getIssn(),
                book.getFormat(),
                book.getPageCount()
        );
    }
}
