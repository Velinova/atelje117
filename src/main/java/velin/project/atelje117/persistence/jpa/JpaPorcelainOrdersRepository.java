package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.PorcelainOrder;
import velin.project.atelje117.persistence.repositories.IPorcelainOrdersRepository;

import java.util.List;
import java.util.UUID;

public interface JpaPorcelainOrdersRepository extends JpaRepository<PorcelainOrder, Integer> {
    public List<PorcelainOrder> findAllByArtist(int Id);
    public List<PorcelainOrder> findAllByCoworker(int Id);
}
