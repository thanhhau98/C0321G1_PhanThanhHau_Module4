package com.codegym.music.model.service;

import com.codegym.music.model.bean.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Page<Song> findAll(Pageable pageable);

    Song findById(int id);

    void save(Song song);

    void remove(int id);
}
