package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.GraniteOrder;

public interface JpaGraniteOrdersRepository extends JpaRepository<GraniteOrder, Integer> {
  /*  @Query("SELECT go FROM granite_orders go WHERE go.coworker_id = ?1")
    List<GraniteOrder> findByCoworkerId(UUID Id);*/
}
