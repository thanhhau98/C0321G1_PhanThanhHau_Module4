package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.model.bean.Category;
import com.codegym.blog_manager.model.service.IBlogService;
import com.codegym.blog_manager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView listCategory(
            @PageableDefault(value = 2 ,sort = "id",direction = Sort.Direction.ASC) Pageable pageable
    ) {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categorys" , categoryService.findAll(pageable));
        modelAndView.addObject("blogs" , blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("blogs" , blogService.findAll());
        modelAndView.addObject("category" , new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer( @ModelAttribute("category") Category category , RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Add new category successfully!");
        return new ModelAndView("redirect:/category/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("blogs" , blogService.findAll());
        modelAndView.addObject("category" , categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("category") Category category  , RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Update category successfully!");
        return new ModelAndView("redirect:/category/");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id , RedirectAttributes redirect) {
        categoryService.remove(id);
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return new ModelAndView("redirect:/category/");
    }

}
