package controller;

import model.bean.EmailConfigure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "email", new EmailConfigure());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView login(@ModelAttribute("email") EmailConfigure emailConfigure) {
        return new ModelAndView("home", "email", emailConfigure);
    }
}
