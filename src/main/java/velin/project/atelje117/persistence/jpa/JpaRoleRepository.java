package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.Role;
import velin.project.atelje117.model.domain.RoleEnum;

import java.util.Optional;


public interface JpaRoleRepository  extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);

}
