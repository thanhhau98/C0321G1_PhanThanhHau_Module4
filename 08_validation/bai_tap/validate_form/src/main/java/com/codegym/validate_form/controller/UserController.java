package com.codegym.validate_form.controller;

import com.codegym.validate_form.dto.UserDto;
import com.codegym.validate_form.model.bean.User;
import com.codegym.validate_form.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create" ,"user" ,new UserDto());
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(
            @Validated
            @ModelAttribute("user") UserDto userDto,
            BindingResult bindingResult) {
        new UserDto().validate(userDto ,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create");
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            return new ModelAndView("result");
        }
    }

}
