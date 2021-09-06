package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.model.bean.Blog;
import com.codegym.blog_manager.model.service.IBlogService;
import com.codegym.blog_manager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView listBlog(
            @PageableDefault(value = 2, sort = "dateBlog", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blogs", blogService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Add new blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Update blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByHeaderContext(
            @PageableDefault(value = 2, sort = "dateBlog", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(name = "search") Optional<String> search ) {
        Page<Blog> blogs;
        if(search.isPresent()){
            blogs = blogService.findAllByHeaderContextContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
}
