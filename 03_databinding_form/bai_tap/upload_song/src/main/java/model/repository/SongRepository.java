package model.repository;

import model.bean.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository {

    public List<Song> findAll();

    public void save(Song song);

}
