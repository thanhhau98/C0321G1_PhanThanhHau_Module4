package com.codegym.borrow_book.model.service;

import com.codegym.borrow_book.model.bean.Book;
import com.codegym.borrow_book.model.bean.Code;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
//    Page<Blog> findAllByHeaderContextContaining(String headerContext , Pageable pageable);

//    List<Blog> findAll();

    Page<Book> findAll(Pageable pageable);

    Book findById(int id);

    void save(Book book);

//    Book findByCode(Code code);

    void remove(int id);
}
