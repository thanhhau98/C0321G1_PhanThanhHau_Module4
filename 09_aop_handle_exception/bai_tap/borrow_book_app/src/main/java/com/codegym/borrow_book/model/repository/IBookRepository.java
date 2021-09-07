package com.codegym.borrow_book.model.repository;

import com.codegym.borrow_book.model.bean.Book;
import com.codegym.borrow_book.model.bean.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {

//    Book findByCode(Code code);

}
