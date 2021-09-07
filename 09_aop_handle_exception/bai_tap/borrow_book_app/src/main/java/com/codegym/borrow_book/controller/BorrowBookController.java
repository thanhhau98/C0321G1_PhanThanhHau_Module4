package com.codegym.borrow_book.controller;

import com.codegym.borrow_book.exception.NullPointE;
import com.codegym.borrow_book.model.bean.Book;
import com.codegym.borrow_book.model.bean.Code;
import com.codegym.borrow_book.model.service.IBookService;
import com.codegym.borrow_book.model.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BorrowBookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICodeService codeService;

    @GetMapping("")
    public ModelAndView showHome(){
        return new ModelAndView("/home");
    }

    @GetMapping("borrow")
    public ModelAndView listBook(
            @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ){
        return new ModelAndView("/list" , "books" , bookService.findAll(pageable));
    }

    @GetMapping("/set_code/{id}")
    public ModelAndView setCode(@PathVariable int id ,
                                RedirectAttributes redirect) throws NullPointE {
        Code code = new Code();
        Book book =bookService.findById(id);
        code.setCode((int) (Math.random() * 10000));
        code.setBook(book);
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            codeService.save(code);
            redirect.addFlashAttribute("success", "Borrow book successfully!");
            return new ModelAndView("redirect:/borrow");
        } else {
            return new ModelAndView("/error");
        }
    }

    @ExceptionHandler(NullPointE.class)
    public ModelAndView showErr(){
        return new ModelAndView("/error");
    }


    @GetMapping("return")
    public ModelAndView inputCode(){
        return new ModelAndView("/input");
    }

    @PostMapping("return_book")
    public ModelAndView returnBook(@RequestParam int code,
                                   RedirectAttributes redirect){
        Book book = codeService.findById(code).getBook();
        book.setQuantity(book.getQuantity()+1);
        bookService.save(book);
        codeService.remove(code);
        redirect.addFlashAttribute("success", "Return book successfully!");
        return new ModelAndView("redirect:/borrow" );
    }

}
