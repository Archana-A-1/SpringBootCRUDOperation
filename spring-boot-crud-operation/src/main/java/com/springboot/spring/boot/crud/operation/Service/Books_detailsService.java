package com.springboot.spring.boot.crud.operation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring.boot.crud.operation.Model.Books_details;
import com.springboot.spring.boot.crud.operation.Repository.Books_detailsRepository;

@Service
public class Books_detailsService {

    @Autowired
    Books_detailsRepository books_detailsRepository;

    public void saveorUpdateDetails(Books_details books_details) {
        books_detailsRepository.save(books_details);
    }

    public Iterable<Books_details> getAllBooksDetails() {
        // List<Books> books = new ArrayList<Books>();
        // booksRepository.findAll().forEach(books1 > books.add(books1));
        return books_detailsRepository.findAll();
        // return books;
    }

    public Books_details getBooksDetailsById(int id) {
        return books_detailsRepository.findById(id).get();
    }

    public void updateBooksDetails(Books_details books_details, int bookid) {
        books_detailsRepository.save(books_details);
    }

    public void deleteBooksDetails(int id) {
        books_detailsRepository.deleteById(id);
    }

}
