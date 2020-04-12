package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.model.domain.CoworkerUser;

import java.util.List;
import java.util.Optional;

public interface JpaArtistRepository extends JpaRepository<ArtistUser, Integer> {
    Optional<ArtistUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<ArtistUser> findById(int Id);

}
