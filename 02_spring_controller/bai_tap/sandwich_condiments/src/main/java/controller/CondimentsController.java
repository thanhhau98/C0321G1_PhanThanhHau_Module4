package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentsController {

    @GetMapping(name = "/")
    public ModelAndView showCondimentsPage(){
        List<String> condimentsList = new ArrayList<>();
        condimentsList.add("lettuce");
        condimentsList.add("tomato");
        condimentsList.add("mustard");
        condimentsList.add("sprouts");
        return new ModelAndView("input" , "condiments" ,condimentsList);
    }

    @PostMapping ("/save")
    public String save(@RequestParam("condiments") String[] condiments ){
return null;
    }
}
