package com.springboot.spring.boot.crud.operation.Model;

// import java.util.List;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Books")
@NoArgsConstructor
@AllArgsConstructor
public class Books {

    @Id
    @Column(name = "bookid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "author")
    private String author;

    @Column(name = "price")
    private int price;

    public Books(String bookname, String author, int price) {
        this.bookname = bookname;
        this.author = author;
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_details_id")
    // private List<Books_details> books_details;
    private Books_details books_details;
}
