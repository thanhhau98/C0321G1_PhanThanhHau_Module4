package com.codegym.blog_manager.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String headerContext;
    private String context;
    private String dateBlog;

    @ManyToMany
    @JoinTable(name = "blog_category",
                joinColumns = @JoinColumn(name = "blog_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorys;

    public Blog() {
    }

    public Blog(int id, String headerContext, String context, String dateBlog, Set<Category> categorys) {
        this.id = id;
        this.headerContext = headerContext;
        this.context = context;
        this.dateBlog = dateBlog;
        this.categorys = categorys;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeaderContext() {
        return headerContext;
    }

    public void setHeaderContext(String headerContext) {
        this.headerContext = headerContext;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public Set<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(Set<Category> categorys) {
        this.categorys = categorys;
    }
}
