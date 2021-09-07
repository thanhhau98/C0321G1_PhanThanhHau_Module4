package com.codegym.borrow_book.model.bean;

import javax.persistence.*;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code ;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn( name = "book_id" , referencedColumnName = "id")
    private Book book;

    public Code() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
