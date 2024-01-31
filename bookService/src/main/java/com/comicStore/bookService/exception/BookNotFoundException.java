package com.comicStore.bookService.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String s){
        super(s);
    }
}
