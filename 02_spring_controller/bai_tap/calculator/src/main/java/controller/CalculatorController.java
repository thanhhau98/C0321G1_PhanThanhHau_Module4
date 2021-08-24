package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping(value = "/")
    public ModelAndView inputPage(){
        ModelAndView modelAndView = new ModelAndView("input");
        return modelAndView;
    }

    @PostMapping(value = "/result")
    public ModelAndView result(@RequestParam("first_operand") double first_operand , @RequestParam("operator") String operator,
                               @RequestParam("second_operand") double second_operand  ){
        double result1 =0;
        switch (operator){
            case "1": result1 = first_operand+second_operand;
                         break;
            case "2": result1 = first_operand-second_operand;
                break;
            case "3": result1 = first_operand*second_operand;
                break;
            case "4": result1 = first_operand/second_operand;
        }
        return new ModelAndView("result" , "result" , result1) ;
    }
}
