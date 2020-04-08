package velin.project.atelje117.persistence.implementation;

import org.hibernate.cfg.CollectionSecondPass;
import org.hibernate.dialect.function.AnsiTrimEmulationFunction;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.persistence.jpa.JpaArtistRepository;
import velin.project.atelje117.persistence.repositories.IArtistsRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Collection<CoworkerUser> getCoworkers(int Id) {
        ArtistUser artist =  this.repository.getOne(Id);
        return artist.getCoworkers();
    }

    @Override
    public Collection<PlatesInventory> getInventory(int Id) {
        ArtistUser artist = this.repository.getOne(Id);
        return artist.getInventories();
    }
//
//    @Override
//    public Collection<GraniteOrder> getGraniteOrders(int Id) {
//        ArtistUser artist = this.repository.getOne(Id);
//        Collection<CoworkerUser> coworkers = artist.getCoworkers();
//        List<GraniteOrder> graniteOrders = new ArrayList<>();
//        for (CoworkerUser coworker: coworkers
//             ) {
//            graniteOrders.addAll(coworker.getGraniteOrders());
//        }
//        return graniteOrders;
//    }
//
//    @Override
//    public Collection<PorcelainOrder> getPorcelainOrders(int Id) {
//        ArtistUser artist = this.repository.getOne(Id);
//        Collection<CoworkerUser> coworkers = artist.getCoworkers();
//        List<PorcelainOrder> porcelainOrders = new ArrayList<>();
//        for (CoworkerUser coworker: coworkers
//        ) {
//            porcelainOrders.addAll(coworker.getPorcelainOrders());
//        }
//        return porcelainOrders;
//    }


//    @Override
//    public int addCoworker(int Id, CoworkerUser coworker) {
//        ArtistUser artist = this.repository.getOne(Id);
//        Collection<CoworkerUser> coworkers = artist.getCoworkers();
//        coworkers.add(coworker);
//        this.repository.deleteById(Id);
//        this.repository.save(artist);
//        return coworker.getId();
//    }


}
