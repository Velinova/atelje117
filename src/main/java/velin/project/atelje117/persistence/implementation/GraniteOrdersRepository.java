package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.GraniteOrder;
import velin.project.atelje117.persistence.jpa.JpaGraniteOrdersRepository;
import velin.project.atelje117.persistence.repositories.IGraniteOrdersRepository;

import java.util.List;

@Repository
public class GraniteOrdersRepository implements IGraniteOrdersRepository {
    private final JpaGraniteOrdersRepository repository;

    public GraniteOrdersRepository(JpaGraniteOrdersRepository repository){
        this.repository = repository;
    }

    @Override
    public GraniteOrder getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<GraniteOrder> findAll() {
        return this.repository.findAll();
    }

    @Override
    public GraniteOrder save(GraniteOrder order) {
        return this.repository.save(order);
    }

    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(GraniteOrder order) {
        this.repository.delete(order);
    }

   /* @Override
    public List<GraniteOrder> findByCoworkerId(UUID Id) {
        return this.repository.findByCoworkerId(Id);
    }*/
}
