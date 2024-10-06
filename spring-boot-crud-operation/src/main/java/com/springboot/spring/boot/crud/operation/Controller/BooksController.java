package com.springboot.spring.boot.crud.operation.Controller;

// import java.util.List;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.boot.crud.operation.Model.Books;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestEntity;

// import com.springboot.spring.boot.crud.operation.Model.Books;
import com.springboot.spring.boot.crud.operation.Service.BooksService;

import java.net.BindException;
import java.util.NoSuchElementException;

// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    // @PostMapping
    // public int saveBook(@RequestBody Books books) {
    // booksService.saveorUpdate(books);
    // return books.getBookid();
    // }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestParam String bookname, @RequestParam String author,
            @RequestParam int price) {
        // return "Book Id: " + bookid + ", Book Name: " + bookname + ", Author: " +
        // author + ", Price: " + price;
        // booksService.saveorUpdate(bookid, bookname, author, price);
        boolean bookExists = booksService.existsByBooknameAndauthor(bookname, author);
        if (bookExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Book with the same name and author already exists");
        }
        // Books book = new Books(bookname, author, price);
        // booksService.saveorUpdate(book);
        // return ResponseEntity.ok("Book added successfully");
        Books book = new Books();
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPrice(price);
        Books savedBook = booksService.saveorUpdate(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // @GetMapping
    // private Iterable<Books> getAllBooks() {
    // return booksService.getAllBooks();
    // }

    // @GetMapping("/{bookid}")
    // public Books getBooks(@PathVariable("bookid") int bookid) {
    // return booksService.getBooksById(bookid);
    // }

    @GetMapping
    public ResponseEntity<?> getBooks(@RequestParam("bookid") int bookid,
            @RequestParam("bookname") String bookname) {
        try {
            Books books = booksService.getBooksById(bookid);
            return ResponseEntity.ok(books);
        } catch (BindException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }
    // if (bookid == null || bookid.isEmpty()) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("body is
    // required");
    // }
    // if (books != null) {
    // // if (books.getBookname().equals(bookname)) {
    // return ResponseEntity.ok(books.getBookname());
    // } else {
    // throw new UnsupportedOperationException("Unimplemented method");
    // }
    // else {
    // if (bookname.isEmpty()) {
    // return ResponseEntity.badRequest().body("Book id and name are required");
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }
    // return new Books();
    // }

    // @PutMapping("/{bookid}")
    // public Books updateBooks(@PathVariable("bookid") int bookid, @RequestBody
    // Books books) {
    // booksService.saveorUpdate(books);
    // return books;
    // }

    @PutMapping("/{bookid}")
    public ResponseEntity<String> updateBooks(@PathVariable("bookid") int bookid, @RequestParam String bookname,
            @RequestParam String author,
            @RequestParam int price) {
        // boolean booksupdated = booksService.updateBooks(bookid, bookname, author,
        // price);
        // return allParams.toString();
        // if (booksupdated != null) {
        // return ResponseEntity.ok("Book updated successfully");
        // } else {
        // return ResponseEntity.notFound().build();
        // }
        try {
            Books books = booksService.getBooksById(bookid);
            if (books != null) {
                books.setBookname(bookname);
                books.setAuthor(author);
                books.setPrice(price);
                booksService.saveorUpdate(books);
                return ResponseEntity.ok("Book Updated Successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (BindException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

    // @DeleteMapping("/{bookid}")
    // private void deleteBook(@PathVariable("bookid") int bookid) {
    // booksService.delete(bookid);
    // }

    @DeleteMapping("/{bookid}")
    private ResponseEntity<String> deleteBook(@PathVariable("bookid") int bookid) {
        try {
            booksService.delete(bookid);
            return ResponseEntity.ok("Book Deleted Sucessfully");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

}
