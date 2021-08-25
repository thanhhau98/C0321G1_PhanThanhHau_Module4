package model.service;

import model.bean.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {

    public List<Song> findAll();

    public void save(Song song);

}
