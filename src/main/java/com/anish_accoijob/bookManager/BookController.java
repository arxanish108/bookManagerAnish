package com.anish_accoijob.bookManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private BookService bookService = new BookService();

    @PostMapping("/add-new-book")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        //data.put(book.getId(), book);
        String str =bookService.addBook(book);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    @GetMapping("/get-book")
    public ResponseEntity<Book> getBook(@RequestParam Integer id){
        try{
            Book book = bookService.getBook(id);
            return new ResponseEntity<>(book,HttpStatus.OK);
        }
        catch (BookIdInvalidException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/get-all-books")
    public ResponseEntity<ArrayList<Book>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/get-book-by name/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name){
        try {
            return new ResponseEntity<>(bookService.getBook(name),HttpStatus.OK);
        }catch (BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-book-pages")
    public ResponseEntity<Book> updatePages(@RequestParam Integer id,@RequestParam Integer pages){
        try {
            Book book = bookService.updateBookPages(id, pages);
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }catch (BookNotFoundException ex){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        bookService.removeBookById(id);
        return new ResponseEntity<>("book is delete with id: "+id, HttpStatus.OK);
    }
}
