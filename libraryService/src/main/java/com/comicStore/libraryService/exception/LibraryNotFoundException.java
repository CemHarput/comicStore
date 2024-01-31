package com.comicStore.libraryService.exception;

public class LibraryNotFoundException extends RuntimeException{
    public LibraryNotFoundException(String s){
        super(s);
    }
}
