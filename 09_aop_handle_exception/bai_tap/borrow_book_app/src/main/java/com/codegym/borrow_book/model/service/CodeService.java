package com.codegym.borrow_book.model.service;

import com.codegym.borrow_book.model.bean.Code;
import com.codegym.borrow_book.model.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService implements ICodeService{

    @Autowired
    private ICodeRepository codeRepository;

    @Override
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    public Code findById(int id) {
        return codeRepository.findById(id).get();
    }

    @Override
    public void remove(int code) {
        codeRepository.deleteById(code);
    }
}
