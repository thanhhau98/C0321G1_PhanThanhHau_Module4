package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentsController {

    @GetMapping(name = "/")
    public ModelAndView showCondimentsPage(){
        return new ModelAndView("input" );
    }

    @PostMapping ("/save")
    public String save(@RequestParam( name = "condiments") String[] condiments , Model model ){
        model.addAttribute("condiments" , condiments);
        return "result";
    }
}
