package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.CoworkerUser;

import java.util.List;

public interface ICoworkersRepository {
    CoworkerUser getOne(int Id);
    List<CoworkerUser> findAll();
    CoworkerUser save(CoworkerUser coworker);
    void deleteById(int Id);
    void delete(CoworkerUser coworker);
}
