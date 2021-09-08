package com.codegym.music.controller;

import com.codegym.music.dto.SongDto;
import com.codegym.music.model.bean.Song;
import com.codegym.music.model.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView listSong(
            @PageableDefault(value = 2, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return new ModelAndView("/list" , "songs" ,songService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/create" , "song" , new SongDto());
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(
            @Validated
            @ModelAttribute("song") SongDto songDto,
            BindingResult bindingResult,
            RedirectAttributes redirect ) {
        new SongDto().validate(songDto ,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("create");
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            songService.save(song);
            redirect.addFlashAttribute("success", "Add new song successfully!");
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        return new ModelAndView("/edit" , "song" , songService.findById(id));
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("song") Song song, RedirectAttributes redirect) {
        songService.save(song);
        redirect.addFlashAttribute("success", "Update song successfully!");
        return new ModelAndView("redirect:/");
    }
}
