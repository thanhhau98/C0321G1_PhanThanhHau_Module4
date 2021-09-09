package com.codegym.shopping_cart_full.controller;

import com.codegym.shopping_cart_full.dto.CartDto;
import com.codegym.shopping_cart_full.dto.ProductDto;
import com.codegym.shopping_cart_full.model.bean.Product;
import com.codegym.shopping_cart_full.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showListPage(
//            @CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct, Model model
    ) {

//        if (idProduct != -1) {
//            model.addAttribute("historyProduct", productService.findById(idProduct).get());
//        }

        return new ModelAndView("product/list", "productList", productService.findAll());
    }

    @GetMapping("/add/{id}")
    public ModelAndView addToCart(@PathVariable Long id,
                                  @SessionAttribute CartDto cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {

            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            cart.addProduct(productDto);
        }

        return new ModelAndView("redirect:/shop");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id,
                                   HttpServletResponse response) {

        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail", "product", productService.findById(id).get());

    }

}
