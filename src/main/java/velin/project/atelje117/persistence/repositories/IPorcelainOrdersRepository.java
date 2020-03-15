package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.PorcelainOrder;

import java.util.List;
import java.util.UUID;

public interface IPorcelainOrdersRepository {
    PorcelainOrder getOne(int Id);
    List<PorcelainOrder> findAll();
    PorcelainOrder save(PorcelainOrder order);
    void deleteById(int Id);
    void delete(PorcelainOrder order);
/*
    List<PorcelainOrder> findByCoworkerId(UUID Id);
*/
}
