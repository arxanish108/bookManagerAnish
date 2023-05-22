package com.anish_accoijob.bookManager;

public class BookIdInvalidException extends RuntimeException {
    public BookIdInvalidException(Integer id){
        super("Book not present with id: "+id);
    }
}
