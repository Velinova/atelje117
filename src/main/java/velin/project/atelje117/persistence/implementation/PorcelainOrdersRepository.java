package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.PorcelainOrder;
import velin.project.atelje117.persistence.jpa.JpaPorcelainOrdersRepository;
import velin.project.atelje117.persistence.repositories.IPorcelainOrdersRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class PorcelainOrdersRepository implements IPorcelainOrdersRepository {
    private final JpaPorcelainOrdersRepository repository;

    public PorcelainOrdersRepository(JpaPorcelainOrdersRepository repository){
        this.repository = repository;
    }

    @Override
    public PorcelainOrder getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<PorcelainOrder> findAll() {
        return this.repository.findAll();
    }

    @Override
    public PorcelainOrder save(PorcelainOrder order) {
        return this.repository.save(order);
    }

    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(PorcelainOrder order) {
        this.repository.delete(order);
    }

    @Override
    public List<PorcelainOrder> findByArtistId(int Id) {
        return this.repository.findAllByArtist(Id);
    }

    @Override
    public List<PorcelainOrder> findByCoworkerId(int Id) {
        return this.repository.findAllByCoworker(Id);
    }

}
