package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.model.bean.Blog;
import com.codegym.blog_manager.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    IBlogService blogService;

    @GetMapping("")
    public ModelAndView listBlog() {
        return new ModelAndView("/list", "blogs", blogService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create" , "blog" , new Blog());
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog , RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Add new blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        return new ModelAndView("/edit" ,"blog" , blogService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog , RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Update blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id , RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewForm(@PathVariable int id  ) {
        return new ModelAndView("/detail" , "blog" , blogService.findById(id));
    }
}
