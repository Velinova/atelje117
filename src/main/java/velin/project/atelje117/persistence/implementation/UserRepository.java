package velin.project.atelje117.persistence.implementation;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.User;
import velin.project.atelje117.persistence.jpa.JpaUserRepository;
import velin.project.atelje117.persistence.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final JpaUserRepository repository;

    public UserRepository(JpaUserRepository repository){
        this.repository = repository;
    }
    @Override
    public User getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return this.repository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);

    }
}
