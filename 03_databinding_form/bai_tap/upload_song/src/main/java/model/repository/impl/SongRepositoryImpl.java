package model.repository.impl;


import model.bean.Song;
import model.repository.SongRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SongRepositoryImpl implements SongRepository {

    private static Map<String, Song> songs;

    static {
        songs = new HashMap<>();
        songs.put("1", new Song("1", "Laptop","100","a" ));
        songs.put("2", new Song("2", "asd","100","a" ));
        songs.put("3", new Song("3", "c","2","b" ));
    }

    @Override
    public List<Song> findAll() {
        return new ArrayList<>(songs.values());
    }

    @Override
    public void save(Song song) {
        songs.put(song.getName(),song);
    }
}
