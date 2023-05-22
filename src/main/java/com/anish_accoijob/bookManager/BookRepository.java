package com.anish_accoijob.bookManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class BookRepository {
    private HashMap<Integer,Book> bookData = new HashMap<>();

    public void add(Book book) {
        bookData.put(book.getId(),book);
    }

    public Optional<Book> getById(Integer id) {
        if(bookData.containsKey(id)){
            Book bookToReturn = bookData.get(id);
            return Optional.of(bookToReturn);
        }
        return Optional.empty();
    }

    public ArrayList<Book> getAll() {
        return new ArrayList<>(bookData.values());
    }

    public void update(Book book) {
        bookData.put(book.getId(),book);
    }

    public void delete(Integer id) {
        bookData.remove(id);
    }
}
