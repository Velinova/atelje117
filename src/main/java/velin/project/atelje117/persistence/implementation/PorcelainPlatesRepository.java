package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.PorcelainPlate;
import velin.project.atelje117.persistence.jpa.JpaPorcelainPlatesRepository;
import velin.project.atelje117.persistence.repositories.IPorcelainPlatesRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class PorcelainPlatesRepository implements IPorcelainPlatesRepository {
    private final JpaPorcelainPlatesRepository repository;

    public PorcelainPlatesRepository(JpaPorcelainPlatesRepository repository){
        this.repository = repository;
    }

    @Override
    public PorcelainPlate getOne(String Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<PorcelainPlate> findAll() {
        return this.repository.findAll();
    }

    @Override
    public PorcelainPlate save(PorcelainPlate plate) {
        return this.repository.save(plate);
    }

    @Override
    public void deleteById(String Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(PorcelainPlate plate) {
        this.repository.delete(plate);
    }
}
