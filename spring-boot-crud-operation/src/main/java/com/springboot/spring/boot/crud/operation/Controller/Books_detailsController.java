package com.springboot.spring.boot.crud.operation.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring.boot.crud.operation.Model.Books_details;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.spring.boot.crud.operation.Service.Books_detailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/bookdetails")
public class Books_detailsController {

    @Autowired
    Books_detailsService books_detailsService;

    @PostMapping
    public int saveBookDetails(@RequestBody Books_details books_details) {
        books_detailsService.saveorUpdateDetails(books_details);
        return books_details.getBookid();
    }

    @GetMapping
    private Iterable<Books_details> getAllBooksDetails() {
        return books_detailsService.getAllBooksDetails();
    }

    @GetMapping("/{bookid}")
    public Books_details getBooksDetails(@PathVariable("bookid") int bookid) {
        return books_detailsService.getBooksDetailsById(bookid);
    }

    @PutMapping("/{bookid}")
    public Books_details updateBooksDetails(@PathVariable("bookid") int bookid,
            @RequestBody Books_details books_details) {
        books_detailsService.saveorUpdateDetails(books_details);
        return books_details;
    }

    @DeleteMapping("/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) {
        books_detailsService.deleteBooksDetails(bookid);
    }

}
