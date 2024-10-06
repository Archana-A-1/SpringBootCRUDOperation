package com.springboot.spring.boot.crud.operation.Repository;

// import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;

import com.springboot.spring.boot.crud.operation.Model.Books;
// import com.springboot.spring.boot.crud.operation.Model.Books_details;

public interface BooksRepository extends CrudRepository<Books, Integer> {

    boolean existsByBooknameIgnoreCaseAndAuthorIgnoreCase(String bookname, String author);

    @Query(value = "Select * from Books", nativeQuery = true)
    Optional<Books> findById(Integer id);

    @Query(value = "insert into Books(bookname,author,price) values(:bookname,:author,:price)", nativeQuery = true)
    void save();

    @Query(value = "update Books set bookname = :bookname, author = :author, price = :price where bookid = :bookid", nativeQuery = true)
    void saveOrUpdate();

    // @Query(value = "delete from Books where bookid = :bookid", nativeQuery =
    // true)
    void deleteById(Integer id);

}
