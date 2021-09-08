package com.codegym.music.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;

    @NotEmpty
    @Size(max = 800)
    private String name;


    @NotEmpty
    @Size(max = 300)
    private String singer;

    @NotEmpty
    @Size(max = 1000)
    private String kindOfMusic;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        if (!songDto.kindOfMusic.matches("^[a-zA-Z0-9,]*$")){
            errors.rejectValue("kindOfMusic", "kindOfMusic.matches");
        }
        if (!songDto.singer.matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("singer", "singer.matches");
        }
        if (!songDto.name.matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("name", "name.matches");
        }
    }
}
