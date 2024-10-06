package com.springboot.spring.boot.crud.operation.Service;

import java.net.BindException;
import java.util.NoSuchElementException;

// import java.util.ArrayList;
// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.spring.boot.crud.operation.Model.Books;
import com.springboot.spring.boot.crud.operation.Repository.BooksRepository;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Books saveorUpdate(Books books) {
        return booksRepository.save(books);
    }

    public boolean existsByBooknameAndauthor(String bookname, String author) {
        return booksRepository.existsByBooknameIgnoreCaseAndAuthorIgnoreCase(bookname, author);
    }
    // public void saveOrUpdate(int bookid, String bookname, String author, int
    // price) {
    // Books books = new Books();
    // books.setBookid(bookid);
    // books.setBookname(bookname);
    // books.setAuthor(author);
    // books.setPrice(price);
    // booksRepository.save(books);
    // }

    public Iterable<Books> getAllBooks() {
        // List<Books> books = new ArrayList<Books>();
        // booksRepository.findAll().forEach(books1 > books.add(books1));
        return booksRepository.findAll();
        // return books;
    }

    public Books getBooksById(int id) throws BindException {
        // return booksRepository.findById(id).get();
        return booksRepository.findById(id)
                .orElseThrow(() -> new BindException("Book with ID " + id + "not found"));
    }

    public void updateBooks(Books books, int bookid) {
        booksRepository.save(books);
    }

    // public void delete(int id) {
    // booksRepository.deleteById(id);
    // }

    public void delete(int id) {
        if (!booksRepository.existsById(id)) {
            throw new NoSuchElementException("Book not found");
        }
        booksRepository.deleteById(id);
    }

    // public void saveorUpdate(String bookname, String author, int price) {
    // throw new UnsupportedOperationException("Unimplemented method
    // 'saveorUpdate'");
    // }
}
