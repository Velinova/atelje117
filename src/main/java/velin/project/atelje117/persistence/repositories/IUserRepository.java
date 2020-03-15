package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.User;
import velin.project.atelje117.persistence.jpa.JpaUserRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    User getOne(int Id);
    List<User> findAll();
    User save(User coworker);
    void deleteById(int Id);
    void delete(User coworker);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
