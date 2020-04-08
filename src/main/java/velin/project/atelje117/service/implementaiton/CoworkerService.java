package velin.project.atelje117.service.implementaiton;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import velin.project.atelje117.mapper.artists.ArtistMapper;
import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.model.domain.CoworkerUser;
import velin.project.atelje117.persistence.repositories.ICoworkersRepository;
import velin.project.atelje117.service.services.ICoworkerService;
import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CoworkerService implements ICoworkerService {

    private final ICoworkersRepository coworkersRepository;
    public CoworkerService(ICoworkersRepository coworkersRepository){
        this.coworkersRepository = coworkersRepository;
    }

    @Override
    public List<ArtistGridModel> getColleaguesArtists(int Id) {
        CoworkerUser coworker = coworkersRepository.getOne(Id);
        Set<ArtistUser> artists = coworker.getArtists();
        List<ArtistGridModel> list = new ArrayList<>();
        ArtistMapper mapper = new ArtistMapper();

        artists.forEach( artist -> {
            ArtistGridModel model = mapper.MapToGridModel(artist);
            model.UnpaidAmount = coworkersRepository.getUnpaidAmount(artist.getId(), Id);
            list.add(model);
        });
        return list;
    }
}
