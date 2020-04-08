package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.CoworkerUser;
import velin.project.atelje117.persistence.jpa.JpaCoworkersRepository;
import velin.project.atelje117.persistence.repositories.ICoworkersRepository;

import java.util.List;

@Repository
public class CoworkerRepository implements ICoworkersRepository {
    private final JpaCoworkersRepository repository;

    public CoworkerRepository(JpaCoworkersRepository repository){
        this.repository = repository;
    }

    @Override
    public CoworkerUser getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<CoworkerUser> findAll() {
        return this.repository.findAll();
    }


    @Override
    public CoworkerUser save(CoworkerUser coworker) {
        return this.repository.save(coworker);
    }


    @Override
    public void deleteById(int Id) {
        this.repository.deleteById((Id));
    }

    @Override
    public void delete(CoworkerUser coworker) {
        this.repository.delete(coworker);
    }

    @Override
    public int getUnpaidAmount(int ArtistId, int CoworkerId) {
        return 0;
    }

}
