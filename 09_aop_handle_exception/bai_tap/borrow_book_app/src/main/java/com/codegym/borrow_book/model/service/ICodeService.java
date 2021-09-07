package com.codegym.borrow_book.model.service;
import com.codegym.borrow_book.model.bean.Code;

public interface ICodeService {

    void save(Code code);

    Code findById(int id);

    void remove(int code);
}
