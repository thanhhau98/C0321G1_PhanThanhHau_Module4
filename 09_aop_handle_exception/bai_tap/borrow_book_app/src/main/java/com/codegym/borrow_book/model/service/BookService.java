package com.codegym.borrow_book.model.service;

import com.codegym.borrow_book.model.bean.Book;
import com.codegym.borrow_book.model.bean.Code;
import com.codegym.borrow_book.model.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

//    @Override
//    public Book findByCode(Code code) {
//        return bookRepository.findByCode(code);
//    }

    @Override
    public void remove(int id) {

    }
}
