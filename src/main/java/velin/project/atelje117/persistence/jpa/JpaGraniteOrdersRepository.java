package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.GraniteOrder;

import java.util.List;

public interface JpaGraniteOrdersRepository extends JpaRepository<GraniteOrder, Integer> {
    public List<GraniteOrder> findAllByArtist(int Id);
    public List<GraniteOrder> findAllByCoworker(int Id);
}
