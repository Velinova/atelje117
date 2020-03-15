package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.PorcelainOrder;
import velin.project.atelje117.model.domain.PorcelainPlate;

import java.util.List;
import java.util.UUID;

public interface IPorcelainPlatesRepository {
    PorcelainPlate getOne(String Id);
    List<PorcelainPlate> findAll();
    PorcelainPlate save(PorcelainPlate plate);
    void deleteById(String Id);
    void delete(PorcelainPlate plate);
}
