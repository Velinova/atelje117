package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.CoworkerUser;

import java.util.Optional;

public interface JpaCoworkersRepository extends JpaRepository<CoworkerUser, Integer> {
    Optional<CoworkerUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);


}
