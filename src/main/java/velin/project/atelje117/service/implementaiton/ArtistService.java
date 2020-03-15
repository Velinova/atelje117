package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import velin.project.atelje117.mapper.artists.ArtistMapper;
import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.persistence.repositories.IArtistsRepository;
import velin.project.atelje117.service.services.IArtistService;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;

import java.util.ArrayList;
import java.util.List;
@Service
public class ArtistService implements IArtistService {
    private final IArtistsRepository artistsRepository;
    public ArtistService(IArtistsRepository artistsRepository){
        this.artistsRepository = artistsRepository;
    }

    @Override
    public List<ArtistGridModel> getAll() {
        ArtistMapper mapper = new ArtistMapper();
        List<ArtistGridModel> list = new ArrayList<ArtistGridModel>();

         artistsRepository.findAll().forEach(artist -> {
             list.add(mapper.MapToGridModel(artist));
         });

         return list;
}

    @Override
    public ArtistUser registerArtist(ArtistUser artist) {
        return null;
    }

    @Override
    public ArtistUser logInArtist(String username, String password) {
        return null;
    }
}
