package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.model.bean.Blog;
import com.codegym.blog_manager.model.bean.Category;
import com.codegym.blog_manager.model.service.IBlogService;
import com.codegym.blog_manager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/Blog/api/v1.0")
public class RestfullController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog/view")
    public ResponseEntity<Blog> findById(@RequestParam int id) {
        Blog blog = blogService.findById(id);
        if (blog.equals(null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/blog/search")
    public ResponseEntity<List<Blog>> findByHeaderContext(@RequestParam String headerContext) {
        List<Blog> blogs = blogService.findByHeaderContextContaining(headerContext);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> findAllBlog(
            @PageableDefault(value = 2, sort = "dateBlog", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Blog> blogs = blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

//    @GetMapping("/blog")
//    public ResponseEntity<List<Blog>> findAllBlog() {
//        List<Blog> blogs = blogService.findAll();
//        if (blogs.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogs, HttpStatus.OK);
//    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id) {
       Blog blog = blogService.findById(id);
        if (blog.equals(null)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> findByCategory(@PathVariable int id) {
        List<Blog> blogs = blogService.findByCategorys_Id(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


}
