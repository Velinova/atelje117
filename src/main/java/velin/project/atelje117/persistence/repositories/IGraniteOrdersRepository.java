package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.GraniteOrder;

import java.util.List;

public interface IGraniteOrdersRepository {
    GraniteOrder getOne(int Id);
    List<GraniteOrder> findAll();
    GraniteOrder save(GraniteOrder order);
    void deleteById(int Id);
    void delete(GraniteOrder order);
/*    List<GraniteOrder> findByCoworkerId(UUID Id);*/

}
