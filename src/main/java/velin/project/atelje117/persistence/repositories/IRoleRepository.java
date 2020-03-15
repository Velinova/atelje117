package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.Role;
import velin.project.atelje117.model.domain.RoleEnum;
import velin.project.atelje117.persistence.jpa.JpaRoleRepository;

import java.util.Optional;

public interface IRoleRepository {
    Optional<Role> findByName(RoleEnum name);

}

