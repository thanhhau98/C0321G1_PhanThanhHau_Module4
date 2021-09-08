package com.codegym.music.model.repository;

import com.codegym.music.model.bean.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}
