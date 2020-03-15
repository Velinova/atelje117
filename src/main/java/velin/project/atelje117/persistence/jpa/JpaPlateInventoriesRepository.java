package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.PlatesInventory;

import java.util.List;
import java.util.UUID;

public interface JpaPlateInventoriesRepository extends JpaRepository<PlatesInventory, Integer> {
    /*@Query("SELECT i FROM inventories i WHERE i.artist_id = ?1")
    List<PlatesInventory> findByArtistId(UUID Id);*/
}
