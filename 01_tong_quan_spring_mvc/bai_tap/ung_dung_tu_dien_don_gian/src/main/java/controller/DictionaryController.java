package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping(path = "/")
    public ModelAndView showInputPage (){
        return new ModelAndView("input");
    }

    @GetMapping(path = "/result")
    public ModelAndView showResult(@RequestParam("txtSearch") String search){
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        String result = dictionary.get(search);
        if(result != null){
          return new ModelAndView("result","result",result);
        } else {
           return new ModelAndView("result" , "result", "not found") ;
        }
    }

}
