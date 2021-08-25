package controller;

import model.bean.Song;
import model.service.SongService;
import model.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {

    @Autowired
     private  SongService songService ;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home", "song", new Song());
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView login(@ModelAttribute("song") Song song) {
        songService.save(song);
        return new ModelAndView("list", "songs", songService.findAll());
    }
}
