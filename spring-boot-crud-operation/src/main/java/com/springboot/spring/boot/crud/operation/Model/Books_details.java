package com.springboot.spring.boot.crud.operation.Model;

import java.util.Date;
// import java.util.List;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Books_details")
@NoArgsConstructor
@AllArgsConstructor
public class Books_details {

    @Id
    @Column(name = "bookid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;

    @Column(name = "publisher")
    public String publisher;

    @Column(name = "publish_date")
    public Date publish_date;

    @Column(name = "book_edition")
    public String book_edition;

}
