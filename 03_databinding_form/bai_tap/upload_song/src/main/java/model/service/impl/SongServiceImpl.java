package model.service.impl;

import model.bean.Song;
import model.repository.SongRepository;
import model.repository.impl.SongRepositoryImpl;
import model.service.SongService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    SongRepository songRepository = new SongRepositoryImpl();
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}
