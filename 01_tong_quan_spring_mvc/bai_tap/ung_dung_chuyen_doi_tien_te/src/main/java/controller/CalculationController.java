package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculationController {

    @GetMapping(value = "/")
    public ModelAndView inputPage(){
        ModelAndView modelAndView = new ModelAndView("input");
        return modelAndView;
    }

    @GetMapping(value = "/result")
    public ModelAndView result(@RequestParam("rate") double rate ,@RequestParam("usd") double usd ){
        ModelAndView modelAndView = new ModelAndView();
        double vnd = usd*rate;
        modelAndView.addObject("rate" , rate);
        modelAndView.addObject("usd" , usd);
        modelAndView.addObject("vnd" , vnd);
        return modelAndView ;
    }
}
