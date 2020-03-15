package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.ArtistUser;

import java.util.Optional;

public interface JpaArtistRepository extends JpaRepository<ArtistUser, Integer> {
    Optional<ArtistUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
