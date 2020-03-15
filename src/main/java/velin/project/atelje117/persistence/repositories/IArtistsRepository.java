package velin.project.atelje117.persistence.repositories;


import velin.project.atelje117.model.domain.ArtistUser;

import java.util.List;

public interface IArtistsRepository {

    ArtistUser getOne(int Id);
    List<ArtistUser> findAll();
    ArtistUser save(ArtistUser artist);
    void deleteById(int Id);
    void delete(ArtistUser artist);


}
