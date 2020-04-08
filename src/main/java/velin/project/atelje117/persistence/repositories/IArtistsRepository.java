package velin.project.atelje117.persistence.repositories;


import org.springframework.data.jdbc.repository.query.Query;
import velin.project.atelje117.model.domain.*;

import java.util.Collection;
import java.util.List;

public interface IArtistsRepository {

    ArtistUser getOne(int Id);
    List<ArtistUser> findAll();
    ArtistUser save(ArtistUser artist);
    void deleteById(int Id);
    void delete(ArtistUser artist);
    Collection<CoworkerUser> getCoworkers(int Id);
    Collection<PlatesInventory> getInventory(int Id);
//    Collection<GraniteOrder> getGraniteOrders(int Id);
//    Collection<PorcelainOrder> getPorcelainOrders(int Id);
//    int addCoworker(int Id, CoworkerUser coworker);

}
