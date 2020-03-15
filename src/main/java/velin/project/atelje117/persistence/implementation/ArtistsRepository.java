package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.persistence.jpa.JpaArtistRepository;
import velin.project.atelje117.persistence.repositories.IArtistsRepository;

import java.util.List;

@Repository
public class ArtistsRepository implements IArtistsRepository {
    private final JpaArtistRepository repository;

    public ArtistsRepository(JpaArtistRepository repository){
        this.repository = repository;
    }

    @Override
    public ArtistUser getOne(int Id) {
         return this.repository.getOne((Id));
    }

    @Override
    public List<ArtistUser> findAll() {
        return this.repository.findAll();
    }

    @Override
    public ArtistUser save(ArtistUser artist) {
        return this.repository.save(artist);
    }


    @Override
    public void deleteById(int Id) {
        this.repository.deleteById((Id));
    }

    @Override
    public void delete(ArtistUser artist) {
        this.repository.delete((artist));
    }
}
