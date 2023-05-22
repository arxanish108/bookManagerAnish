package com.anish_accoijob.bookManager;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String str){
        super(str);
    }
}
