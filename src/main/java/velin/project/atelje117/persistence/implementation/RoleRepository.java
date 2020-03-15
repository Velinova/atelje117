package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.Role;
import velin.project.atelje117.model.domain.RoleEnum;
import velin.project.atelje117.persistence.jpa.JpaRoleRepository;
import velin.project.atelje117.persistence.jpa.JpaUserRepository;
import velin.project.atelje117.persistence.repositories.IRoleRepository;
import velin.project.atelje117.persistence.repositories.IUserRepository;

import java.util.Optional;
@Repository
public class RoleRepository implements IRoleRepository {
    private final JpaRoleRepository repository;

    public RoleRepository(JpaRoleRepository repository){
        this.repository = repository;
    }
    @Override
    public Optional<Role> findByName(RoleEnum name) {
        return this.repository.findByName(name);
    }
}
